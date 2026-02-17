package com.Apex.Mtechno.Dao;




import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

import com.Apex.Mtechno.Entity.Login;
import com.Apex.Mtechno.Entity.Patient;
import com.Apex.Mtechno.Service.LoginGmail;
import com.Apex.Mtechno.Service.PauseLogin;

public class LoginDao {

    public void doLogin(Patient patient, Login l) {

        // Hibernate Configuration
        Configuration cfg = new Configuration();
        cfg.configure();
        cfg.addAnnotatedClass(Patient.class);
        cfg.addAnnotatedClass(Login.class);
        SessionFactory sf = cfg.buildSessionFactory();
        Session session = sf.openSession();

        Transaction tx = null;

        try {
            // Find patient by email
            Criteria criteria = session.createCriteria(Patient.class);
            criteria.add(Restrictions.eq("email", patient.getEmail()));
            Patient p = (Patient) criteria.uniqueResult();

            if (p == null) {
                System.out.println("Email not Exist...");
                return;
            }

            // Fetch login record for this patient (using same patient id)
            Criteria loginCriteria = session.createCriteria(Login.class);
            loginCriteria.add(Restrictions.eq("id", p.getId())); // same id as patient
            Login existingLogin = (Login) loginCriteria.uniqueResult();

            // Agar record nahi mila to new create karo
            
            if (existingLogin == null) {
                existingLogin = new Login();
                existingLogin.setId(p.getId());
                existingLogin.setFailedAttempts(0);
                existingLogin.setLockedtime(0);
            }

            // Check if account is locked
            
            long currentTime = System.currentTimeMillis();
            long lockTime = existingLogin.getLockedtime();
            long diffMinutes = (currentTime - lockTime) / (60 * 1000);

            if (existingLogin.getFailedAttempts() >= 3 && diffMinutes < 2) {
                System.out.println("Account is locked. Try again after 2 minutes.");
                
                session.close();
                return;
            }

            // If password matches
            if (p.getPassword().equals(patient.getPassword())) {
                System.out.println("Login Successful..!");
                System.out.println(p);
                
                LoginGmail g=new LoginGmail();
                g.gmail(p);
                
                existingLogin.setFailedAttempts(0);
                existingLogin.setLockedtime(0);
            } else {
                System.out.println("Invalid password..!");
                existingLogin.setFailedAttempts(existingLogin.getFailedAttempts() + 1);

                if (existingLogin.getFailedAttempts() >= 3) {
                    System.out.println("Too many failed attempts! Account locked for 2 minutes.");
                    
                    existingLogin.setLockedtime(System.currentTimeMillis());
                }
            }

            // Save/Update login record
            tx = session.beginTransaction();
            session.saveOrUpdate(existingLogin);
            tx.commit();

            System.out.println("Failed Attempts: " + existingLogin.getFailedAttempts());

        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
            sf.close();
        }
    }
}


/*import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

import com.Apex.Mtechno.Entity.Login;
import com.Apex.Mtechno.Entity.Patient;
import com.Apex.Mtechno.Service.PauseLogin;

public class LoginDao {
	
	

	public void doLogin(Patient patient,Login l) {
		
		
		
		Configuration cfg=new Configuration();
		cfg.configure();
		cfg.addAnnotatedClass(Patient.class);
		cfg.addAnnotatedClass(Login.class);
		SessionFactory sf=cfg.buildSessionFactory();
		Session session=sf.openSession();
		
		Criteria criteria=session.createCriteria(Patient.class);
		criteria.add(Restrictions.eq("email", patient.getEmail()));
		Patient p=(Patient)criteria.uniqueResult();
		if(l.getFailedAttempts()<=3){
		if(p==null) {
			System.out.println("Email not Exist...");
			l.setFailedAttempts(l.getFailedAttempts()+1);
			Transaction tx = session.beginTransaction();
			session.saveOrUpdate(l);
			tx.commit();
			System.out.println(l.getFailedAttempts());
		}
		  
		else {
		if(p.getPassword().equals(patient.getPassword())) {
			System.out.println("Login Successfull...");
			System.out.println(p);
		}
		else {
			System.out.println("Invalid password..!");
			l.setFailedAttempts(l.getFailedAttempts()+1);
			Transaction tx = session.beginTransaction();
			session.saveOrUpdate(l);
			tx.commit();
			System.out.println(l.getFailedAttempts());
		}
		
		
		session.close();
	}
		}
		else {
			PauseLogin pl=new PauseLogin();
			pl.stopLogin(2, l.getFailedAttempts());
			
		}
	}

}*/

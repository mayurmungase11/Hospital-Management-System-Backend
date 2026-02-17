package com.Apex.Mtechno.Dao;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

import com.Apex.Mtechno.Entity.Appointment;
import com.Apex.Mtechno.Entity.Doctor;
import com.Apex.Mtechno.Entity.Patient;
import com.Apex.Mtechno.Entity.PaymentCD;
import com.Apex.Mtechno.Service.CancelationMail;
import com.Apex.Mtechno.Service.RefundSet;

public class CancelApDao {

	public void doCancelAp(Appointment appointment) {
		
		Configuration cfg=new Configuration();
		cfg.configure();
		cfg.addAnnotatedClass(Appointment.class);
		cfg.addAnnotatedClass(PaymentCD.class);
		cfg.addAnnotatedClass(Patient.class);
		SessionFactory sf=cfg.buildSessionFactory();
		Session session=sf.openSession();
		
		Criteria criteria=session.createCriteria(Appointment.class);
		criteria.add(Restrictions.eq("id", appointment.getId()));
		Appointment ap=(Appointment)criteria.uniqueResult();
		
		
		Criteria criteria2=session.createCriteria(Doctor.class);
		criteria2.add(Restrictions.ilike("name", ap.getDr_name().trim(), MatchMode.EXACT));
		Doctor dr=(Doctor)criteria2.uniqueResult();
		
		System.out.println(ap.getDr_name());
		System.out.println(dr);
		
		
		Criteria criteria0=session.createCriteria(Patient.class);
		criteria0.add(Restrictions.eq("id", appointment.getId()));
		Patient rp=(Patient)criteria0.uniqueResult();
		
		if(ap!=null) {
		
		Criteria criteria1=session.createCriteria(PaymentCD.class);
		criteria1.add(Restrictions.eq("patientid", appointment.getId()));
		PaymentCD payment=(PaymentCD)criteria1.uniqueResult();
		
		
		
		if(payment==null) {
			System.out.println("You did'nt pay fees for Appointment Confirmation");
		}
		else {
			
		RefundSet r=new RefundSet();
		r.doRefund(payment, ap);
		
		if(ap.getStatus().equalsIgnoreCase("Confirmed")) {
		ap.setStatus("Cancelled");
		session.update(ap);
		session.beginTransaction().commit();
		
		
		CancelationMail mail=new CancelationMail();
		mail.gmailtoPatient(rp);
	//	mail.gmailtoDoctor(dr, ap);
		
		}
		
		}
		}
	else {
			System.out.println("AppoinmtmentID is not Exist not Valid");
	  	        }
		
		
		session.close();
		
		
		
	
		
		
		
	}

}

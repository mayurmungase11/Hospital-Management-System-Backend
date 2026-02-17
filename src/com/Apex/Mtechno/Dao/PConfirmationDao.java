package com.Apex.Mtechno.Dao;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

import com.Apex.Mtechno.Entity.Appointment;
import com.Apex.Mtechno.Entity.Doctor;
import com.Apex.Mtechno.Entity.Patient;
import com.Apex.Mtechno.Entity.PaymentCD;
import com.Apex.Mtechno.Service.GmailForPayment;
import com.Apex.Mtechno.Service.PaymentDetails;

public class PConfirmationDao{

	public void doConfirm(PaymentCD appointment) {
		
		Configuration cfg=new Configuration();
		cfg.configure();
		cfg.addAnnotatedClass(Appointment.class);
		cfg.addAnnotatedClass(Patient.class);
		cfg.addAnnotatedClass(Doctor.class);
		cfg.addAnnotatedClass(PaymentCD.class);
		SessionFactory sf=cfg.buildSessionFactory();
		Session session=sf.openSession();
		
		Transaction tx=session.beginTransaction();
		
		
		
		Criteria criteria=session.createCriteria(Appointment.class);
		criteria.add(Restrictions.eq("id", appointment.getPatientid()));
		Appointment patient=(Appointment)criteria.uniqueResult();
		
		Criteria criteria1=session.createCriteria(Patient.class);
		criteria1.add(Restrictions.eq("mobilenumber", patient.getMobilenumber()));
		Patient rp=(Patient)criteria1.uniqueResult();
	    
		System.out.println(patient);
		
		patient.setFees_paid(true);
		patient.setStatus("Confirmed");
		
		session.update(patient);
		
		tx.commit();
		
		session.close();
		
		
		Session session1=sf.openSession();
		
		Criteria criteria0=session1.createCriteria(Doctor.class);
		  criteria0.add(Restrictions.eq("name", patient.getDr_name()));
		  Doctor dr=(Doctor)criteria0.uniqueResult();
		  
		  PaymentDetails p=new PaymentDetails();
			p.paymentReceipt(appointment, patient,dr);
			
			GmailForPayment gmail=new GmailForPayment();
			gmail.gmail(appointment, rp, patient,dr);
		
		appointment.setStatus("Debited");
		
		appointment.setAmount(dr.getConsulatation_fees());
		session1.save(appointment);
		
		session1.beginTransaction().commit();
		session1.close();
		
		
	}

}

package com.Apex.Mtechno.Dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Projections;

import com.Apex.Mtechno.Entity.Patient;

public class PatientDao {

	public void doRegister(Patient patient) {
		
		Configuration cfg=new Configuration();
		cfg.configure();
		cfg.addAnnotatedClass(Patient.class);
		
		SessionFactory sf=cfg.buildSessionFactory();
		Session session=sf.openSession();
		
		Serializable patientid=session.save(patient);
		
		Criteria criteria=session.createCriteria(Patient.class);
		
		//1. for email_validation(Duplication)_checking
		
		criteria.setProjection(Projections.property("email"));
		
		String enteredmail=patient.getEmail();
		List<String>ls=criteria.list();
		 boolean b=ls.contains(enteredmail);
		if(b) {
			System.out.println("Email is already exist please enter other email");
	
		}
		else {
			
			
			String contact=patient.getMobilenumber();
			
	    // 2.for mobilenumber_validation(Duplication)_checking
			
			criteria.setProjection(Projections.property("mobilenumber"));
			List<String>m=criteria.list();
			boolean ans=m.contains(contact);
			if(ans) {
				System.out.println("Contact number is already used....please enter other contactnumber");
			}
			else {
				
				String username1=patient.getUsername();
				
		// 3..for username_validation(Duplication)_checking
				
				criteria.setProjection(Projections.property("username"));
				List<String>list=criteria.list();
				boolean bl=list.contains(username1);
				if(bl) {
					System.out.println("username is Already Used...!");
				}
				else {
				patient.setAccountStatus("Active");
			session.beginTransaction().commit();
		
		session.close();
		System.out.println("Registration Succcessfull...!");
		System.out.println("Patient ID is:"+patientid);
		
		
				}
			}
		}
		
	}

}

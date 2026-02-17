package com.Apex.Mtechno.Dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Projections;

import com.Apex.Mtechno.Entity.Doctor;



public class DoctorDao {

	public void doRegister(Doctor doctor) {
		
		Configuration cfg=new Configuration();
		cfg.configure();
		cfg.addAnnotatedClass(Doctor.class);
		SessionFactory sf=cfg.buildSessionFactory();
		Session session=sf.openSession();
		session.save(doctor);
		
		
		Criteria criteria=session.createCriteria(Doctor.class);
		criteria.setProjection(Projections.property("email"));
		List<String>ls=criteria.list();
		boolean ans=ls.contains(doctor.getEmail());
	   
		if(ans==false) {
			
		session.beginTransaction().commit();
		session.close();
		
		doctor.setStatus("Available");
		
		}
		else System.out.println("Email is already used..");
	}

	

}

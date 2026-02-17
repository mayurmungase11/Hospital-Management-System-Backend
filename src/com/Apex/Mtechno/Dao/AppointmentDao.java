package com.Apex.Mtechno.Dao;

import java.time.LocalTime;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import com.Apex.Mtechno.Entity.Appointment;

import com.Apex.Mtechno.Entity.Doctor;
import com.Apex.Mtechno.Entity.Patient;
import com.Apex.Mtechno.Service.GmailAppointment;

public class AppointmentDao  {
	


	public void takeAppointment(Appointment appointment) {
		
	 
		
		Configuration cfg=new Configuration();
		cfg.configure();
		cfg.addAnnotatedClass(Appointment.class);
		cfg.addAnnotatedClass(Patient.class);
		cfg.addAnnotatedClass(Doctor.class);
		
		
		SessionFactory sf=cfg.buildSessionFactory();
		Session session=sf.openSession();
		
		// Check patient ID is exist in Database or not 
		
		
		
		
		Criteria criteria0=session.createCriteria(Patient.class);
		criteria0.add(Restrictions.eq("mobilenumber",appointment.getMobilenumber()));
		Patient patient=(Patient)criteria0.uniqueResult();
		
		System.out.println("patient id is :"+patient);
		if(patient!=null) {
			
			appointment.setId(patient.getId());
	
			Criteria criteria00=session.createCriteria(Doctor.class);
			criteria00.add(Restrictions.eq("name", appointment.getDr_name()));
			Doctor Dr=(Doctor)criteria00.uniqueResult();
			
			if(Dr!=null) {
			
			
			//   checking time is free or already Booked ...
			
		 
		 
		 Criteria criteria=session.createCriteria(Appointment.class);
		 criteria.add(Restrictions.eq("date", appointment.getDate()));
		 criteria.setProjection(Projections.property("time"));
		 List<LocalTime>ls=criteria.list();
		boolean result= ls.contains(appointment.getTime());
		if(result) {
			System.out.println("This timeSlot is not available. Choose another");
			
			
		}
		else {
			
			 // Checking particular doctor is available or not at that time
			
			Criteria criteria1=session.createCriteria(Appointment.class);
			criteria1.add(Restrictions.eq("dr_name", appointment.getDr_name()));
			criteria1.add(Restrictions.eq("date", appointment.getDate()));
			criteria1.setProjection(Projections.property("time"));
			
			List<LocalTime>l=criteria1.list();
			
			boolean ans=l.contains(appointment.getTime());
			if(ans) {
				System.out.println("Doctor not available for that time slot");
			}
			else {
				
				appointment.setConsultation_fees(Dr.getConsulatation_fees());
				
				int apID=(int)session.save(appointment);
				session.beginTransaction().commit();
				System.out.println("Appointment booked successful..!");
				 System.out.println("Your appointment ID is: "+apID);
				session.close();
				
				GmailAppointment g=new GmailAppointment();
				g.gmailToPatient(appointment, patient,apID,Dr.getConsulatation_fees());
				g.gmailToDoctor(appointment, Dr);
				
			}
			
		}
			}
			else {
				System.out.println("Dr_Name is not found.. please enter valid dr_name");
			}
		 
	}
	  else {
		  System.out.println("Patient ID is not exist. Please Do Registration firstly");
		
	}

}
}

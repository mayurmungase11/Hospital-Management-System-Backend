package com.Apex.Mtechno.Dao;

import java.time.LocalDate;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

import com.Apex.Mtechno.Entity.Appointment;
import com.Apex.Mtechno.Entity.BillGeneration;
import com.Apex.Mtechno.Entity.Patient;
import com.Apex.Mtechno.Service.BillAmountCalc;
import com.Apex.Mtechno.Service.GmailHospitalBill;

public class BillDao {

	public void doBilling(BillGeneration bill) {
		
		Configuration cfg=new Configuration();
		cfg.configure();
		cfg.addAnnotatedClass(BillGeneration.class);
		cfg.addAnnotatedClass(Appointment.class);
		cfg.addAnnotatedClass(Patient.class);
		SessionFactory sf=cfg.buildSessionFactory();
		Session session=sf.openSession();
		
		Criteria criteria=session.createCriteria(Appointment.class);
		criteria.add(Restrictions.eq("id", bill.getId()));
		Appointment ap=(Appointment)criteria.uniqueResult();
		
		if(ap.getDate().equals(LocalDate.now()) || ap.getDate().isBefore(LocalDate.now())) {
			
			if(ap.getStatus().equalsIgnoreCase("Confirmed")){
				
				ap.setStatus("Completed");
				
			
		
		System.out.println(ap);
		
		
		
		
		Criteria criteria1=session.createCriteria(Patient.class);
		criteria1.add(Restrictions.eq("id", ap.getId()));
		Patient patient=(Patient)criteria1.uniqueResult();
		
		bill.setPatientage(patient.getAge());
		bill.setPatientname(patient.getFullname());
		
		BillAmountCalc calc=new BillAmountCalc();
		String b=calc.generateFinalBill(bill);
		
		System.out.println(b);
		session.save(bill);
		session.update(ap);
		session.beginTransaction().commit();
		
		GmailHospitalBill mail=new GmailHospitalBill();
		mail.gmail(patient, bill, calc);
		
		
       }
			
		}
		
		session.close();
	}

}

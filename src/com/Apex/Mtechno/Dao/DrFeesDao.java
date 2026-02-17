package com.Apex.Mtechno.Dao;

import java.time.LocalDate;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import com.Apex.Mtechno.Entity.Appointment;
import com.Apex.Mtechno.Entity.Doctor;
import com.Apex.Mtechno.Entity.DoctorFeesAudit;
import com.Apex.Mtechno.Service.FeesUpdationGmail;

public class DrFeesDao {

	public void doUpdate(DoctorFeesAudit dr) {
         
		Configuration cfg=new Configuration();
		cfg.configure();
		cfg.addAnnotatedClass(Doctor.class);
		cfg.addAnnotatedClass(DoctorFeesAudit.class);
		SessionFactory sf=cfg.buildSessionFactory();
		
		Session session=sf.openSession();
		
		Doctor doct=session.get(Doctor.class, dr.getDoctorId());
		
		
		
		if(dr.getNewUpdatedFees()>=500 && dr.getNewUpdatedFees()<=5000) {
			
			dr.setOldFees(doct.getConsulatation_fees());
			
			doct.setConsulatation_fees(dr.getNewUpdatedFees());
			
			Criteria criteria=session.createCriteria(Appointment.class);
			//criteria.add(Restrictions.ilike("dr_name", doct.getName()));
			criteria.add(Restrictions.ilike("dr_name", doct.getName().trim(), MatchMode.ANYWHERE));
			criteria.add(Restrictions.gt("date", LocalDate.now()));
			criteria.setProjection(Projections.rowCount());
             Long affectedAppointments=(Long)criteria.uniqueResult();
             if (affectedAppointments == null) {
            	    affectedAppointments = 0L;
            	}
		
			Transaction tx=session.beginTransaction();
		session.update(doct);
		session.save(dr);
		tx.commit();
		System.out.println("Fees Updated Successfully..!");
		System.out.println("Affected Appointments is:"+affectedAppointments);
		
		FeesUpdationGmail gmail=new FeesUpdationGmail();
		gmail.gmailToDoctor(doct, dr);
		
		}
		
		else {
			System.out.println("Fees should be between 500 to 5000");
		}
		
		session.close();

		
		
		
	}

}

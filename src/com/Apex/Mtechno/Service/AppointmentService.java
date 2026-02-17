package com.Apex.Mtechno.Service;

import java.time.LocalDateTime;

import com.Apex.Mtechno.Dao.AppointmentDao;
import com.Apex.Mtechno.Entity.Appointment;

public class AppointmentService {

	public void takeAppointment(Appointment appointment) {
		
//		 if(appointment.getFees_paid()==null) {
//			 appointment.setFees_paid("false");
//	     }
//		 if(appointment.getStatus()==null) {
//			 appointment.setStatus("Provisional");
//			}
		 
		 
		appointment.setBookedAppointmentAt(LocalDateTime.now());
		appointment.setModifiedAppointmentAt(LocalDateTime.now());
		
		
		AppointmentValidation av=new AppointmentValidation();
		boolean r=av.dateAndTime(appointment);
		
		if(r) {
		AppointmentDao dao=new AppointmentDao();
		dao.takeAppointment(appointment);
		}
		
	}

}

package com.Apex.Mtechno.Service;

import java.time.LocalDate;



import com.Apex.Mtechno.Entity.Appointment;

public class AppointmentValidation {
	
	public boolean dateAndTime(Appointment appointment) {
		
		if(!appointment.getDate().isAfter(LocalDate.now())) {
			
			System.out.println("Appointment is not available for this date");
			return false;
		}
		else {
			return true;
		}
		
	}

}

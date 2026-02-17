package com.Apex.Mtechno.Controller;

import com.Apex.Mtechno.Entity.Appointment;
import com.Apex.Mtechno.Service.AppointmentService;

public class AppointmentController {

	public void takeAppointment(Appointment appointment) {
		
		
		AppointmentService service=new AppointmentService();
		service.takeAppointment(appointment);
		
	}

}

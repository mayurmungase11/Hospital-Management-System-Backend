package com.Apex.Mtechno.Frontend;

import com.Apex.Mtechno.Controller.CancelApController;
import com.Apex.Mtechno.Entity.Appointment;


public class CancelAppointment {
	
	public static void main(String[] args) {
		
	
	Appointment appointment=new Appointment();
	appointment.setId(120);
	
	
	CancelApController controller=new CancelApController();
	controller.doCancelAp(appointment);
	
	}
}

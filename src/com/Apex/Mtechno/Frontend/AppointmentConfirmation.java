package com.Apex.Mtechno.Frontend;

import com.Apex.Mtechno.Controller.PConfirmationController;

import com.Apex.Mtechno.Entity.PaymentCD;

public class AppointmentConfirmation {
	public static void main(String[] args) {
		
		// Do payment 
		
		//Appointment appointment=new Appointment();
		
		PaymentCD appointment=new PaymentCD();
		appointment.setPatientid(74);
		
		PConfirmationController controller=new PConfirmationController();
		controller.doConfirm(appointment);
	}

}

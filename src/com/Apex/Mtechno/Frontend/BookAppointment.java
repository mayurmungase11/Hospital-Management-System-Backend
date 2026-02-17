package com.Apex.Mtechno.Frontend;

import java.time.LocalDate;
import java.time.LocalTime;

import com.Apex.Mtechno.Controller.AppointmentController;
import com.Apex.Mtechno.Entity.Appointment;

public class BookAppointment {
	public static void main(String[] args) {
		
	
	Appointment appointment=new Appointment();
	appointment.setDr_name("Dr.Mayur");
	appointment.setDate(LocalDate.of(2026, 02,19));
	appointment.setTime(LocalTime.of(11, 52));
	
	appointment.setPatientname("Akshadaa");
	appointment.setMobilenumber("8600224606");
	
	
	AppointmentController controller=new AppointmentController();
	controller.takeAppointment(appointment);
	

}
}

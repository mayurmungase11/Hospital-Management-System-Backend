package com.Apex.Mtechno.Frontend;

import com.Apex.Mtechno.Controller.PatientController;
import com.Apex.Mtechno.Entity.Patient;

public class PatientRegistration {
	public static void main(String[] args) {
		
		Patient patient=new Patient();
		patient.setFullname("tejas");
		patient.setMobilenumber("8600224606");
		patient.setEmail("akshadakarkhile82@gmail.com");
		
		patient.setUsername("tejast_46061");
		patient.setPassword("Teju@007");
		patient.setDOB("30/03/2005");
		patient.setAge(21);
	
		
		
		
		
		PatientController controller=new PatientController();
		
		controller.doRegister(patient);
	}

}

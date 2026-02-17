package com.Apex.Mtechno.Frontend;

import com.Apex.Mtechno.Controller.LoginController;
import com.Apex.Mtechno.Entity.Login;
import com.Apex.Mtechno.Entity.Patient;

public class PatientLogin {
	public static void main(String[] args) {
		
		Patient patient=new Patient();
		patient.setEmail("akshadakarkhile82@gmail.com");
		patient.setPassword("Teju@007");
		
		Login l=new Login();
		LoginController controller=new LoginController();
		controller.doLogin(patient,l);
	}

}

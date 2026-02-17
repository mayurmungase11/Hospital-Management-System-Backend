package com.Apex.Mtechno.Controller;

import com.Apex.Mtechno.Entity.Login;
import com.Apex.Mtechno.Entity.Patient;
import com.Apex.Mtechno.Service.LoginService;

public class LoginController {

	public void doLogin(Patient patient,Login l) {
		
		LoginService service=new LoginService();
		service.doLogin(patient,l);
	}
	
	

}

package com.Apex.Mtechno.Controller;

import com.Apex.Mtechno.Entity.Patient;
import com.Apex.Mtechno.Service.PatientService;

public class PatientController {

	public void doRegister(Patient patient) {
		
		
		PatientService service=new PatientService();
		service.doRegister(patient);
	}

}

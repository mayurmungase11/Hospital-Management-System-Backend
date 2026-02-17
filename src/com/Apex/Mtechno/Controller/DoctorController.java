package com.Apex.Mtechno.Controller;

import com.Apex.Mtechno.Entity.Doctor;
import com.Apex.Mtechno.Service.DoctorService;

public class DoctorController {

	public void doRegister(Doctor doctor) {
		
		DoctorService service=new DoctorService();
		service.doRegister(doctor);
	}

}

package com.Apex.Mtechno.Frontend;

import com.Apex.Mtechno.Controller.DoctorController;
import com.Apex.Mtechno.Entity.Doctor;

public class Admin {
	public static void main(String[] args) {
		
		Doctor doctor=new Doctor();
		doctor.setName("Dr.Suyog");
		doctor.setSpecialization("Sergen");
		doctor.setQualification("B.H.M.S.,M.D(sergery)");
		doctor.setConsulatation_fees(4500);
		doctor.setExperience(5);
		doctor.setEmail("poojamungase9527@gmail.com");
		doctor.setMobilenumber("9699309817");
		doctor.setPassword("gnjb@23D");
		
		DoctorController controller=new DoctorController();
		controller.doRegister(doctor);
	}

}

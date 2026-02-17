package com.Apex.Mtechno.Service;

import java.time.LocalDateTime;

import com.Apex.Mtechno.Dao.DoctorDao;
import com.Apex.Mtechno.Entity.Doctor;

public class DoctorService {

	public void doRegister(Doctor doctor) {
		doctor.setDateofCreation(LocalDateTime.now());
		doctor.setDateOfModification(LocalDateTime.now());
		
		
		DoctorValidation v=new DoctorValidation();
		boolean result1=v.checkValidation(doctor);
		boolean result2=v.emailchecking(doctor);
		boolean result3=v.passachecking(doctor);
		
		if(result1&&result2&&result3) {
			
			String password=doctor.getPassword();
			PassEncryption pass=new PassEncryption();
			String encryptedpass=pass.passwordEncryption(password);
			doctor.setPassword(encryptedpass);
			
		DoctorDao dao=new DoctorDao();
		dao.doRegister(doctor);
		
		if(doctor.getStatus().equalsIgnoreCase("available")) {
			
			DoctorGmail gmail=new DoctorGmail();
			gmail.gmail(doctor);
			
		}
		
		}
		
	}

}

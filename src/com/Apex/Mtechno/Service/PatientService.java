package com.Apex.Mtechno.Service;

import java.time.LocalDateTime;

import com.Apex.Mtechno.Dao.PatientDao;
import com.Apex.Mtechno.Entity.Patient;

public class PatientService {

	public void doRegister(Patient patient) {
		
		patient.setDateOfCreation(LocalDateTime.now());
		patient.setDateOfModification(LocalDateTime.now());
		
		
		
		Validation v=new Validation();
		boolean validity=v.emailchecking(patient);
		boolean result=v.passachecking(patient);
		boolean size=v.contactsize(patient);
		
		
		if(result&&validity&&size) {
		
		//Encrypt passsword
		
		String password=patient.getPassword();
		PassEncryption encrypt=new PassEncryption();
		String encryptedpass=encrypt.passwordEncryption(password);
		patient.setPassword(encryptedpass);
		
		
		PatientDao dao=new PatientDao();
		dao.doRegister(patient );
		
		Gmail gmail=new Gmail();
		gmail.gmail(patient,password);
	}
	}

}

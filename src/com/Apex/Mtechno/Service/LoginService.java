package com.Apex.Mtechno.Service;

import com.Apex.Mtechno.Dao.LoginDao;
import com.Apex.Mtechno.Entity.Login;
import com.Apex.Mtechno.Entity.Patient;

public class LoginService {

	public void doLogin(Patient patient,Login l) {
		
		String password=patient.getPassword();
		PassEncryption pass=new PassEncryption();
		String encryptedpass=pass.passwordEncryption(password);
		patient.setPassword(encryptedpass);
		
		
		LoginDao dao=new LoginDao();
		dao.doLogin(patient,l);
	}

}

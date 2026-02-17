package com.Apex.Mtechno.Service;

import com.Apex.Mtechno.Dao.CancelApDao;
import com.Apex.Mtechno.Entity.Appointment;

public class CancelApService {

	public void doCancelAp(Appointment appointment) {
		
		
		
		CancelApDao dao=new CancelApDao();
		dao.doCancelAp(appointment);
		
	}

}

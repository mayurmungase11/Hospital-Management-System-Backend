package com.Apex.Mtechno.Controller;

import com.Apex.Mtechno.Entity.Appointment;
import com.Apex.Mtechno.Service.CancelApService;

public class CancelApController {

	public void doCancelAp(Appointment appointment) {
		
		
		CancelApService service=new CancelApService();
		service.doCancelAp(appointment);
		
	}

}

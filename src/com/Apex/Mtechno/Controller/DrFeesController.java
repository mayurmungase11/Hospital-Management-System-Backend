package com.Apex.Mtechno.Controller;


import com.Apex.Mtechno.Entity.DoctorFeesAudit;
import com.Apex.Mtechno.Service.DrFeesService;

public class DrFeesController {

	public void doUpdate(DoctorFeesAudit dr) {

  
		
		DrFeesService service=new DrFeesService();
		service.doUpdate(dr);
		
	}

}

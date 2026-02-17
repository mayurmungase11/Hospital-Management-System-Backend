package com.Apex.Mtechno.Frontend;

import com.Apex.Mtechno.Controller.DrFeesController;

import com.Apex.Mtechno.Entity.DoctorFeesAudit;

public class UpdateDrFees {
	public static void main(String[] args) {
		
	
		DoctorFeesAudit dr=new DoctorFeesAudit(); 
	
		dr.setDoctorId(55);
		dr.setNewUpdatedFees(3600);
	
		
	
	DrFeesController controller=new DrFeesController();
	controller.doUpdate(dr);
	
	
	
	}


}

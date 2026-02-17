package com.Apex.Mtechno.Controller;

import com.Apex.Mtechno.Entity.MedicineInventory;
import com.Apex.Mtechno.Service.MedicineService;

public class MedicineController {

	public String manageMedicine(MedicineInventory medicine) {
		
		
		MedicineService service=new MedicineService();
		 String result= service.manageMedicine(medicine);
		 return result;
	}

}

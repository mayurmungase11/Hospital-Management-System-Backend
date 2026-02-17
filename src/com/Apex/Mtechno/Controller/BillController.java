package com.Apex.Mtechno.Controller;

import com.Apex.Mtechno.Entity.BillGeneration;
import com.Apex.Mtechno.Service.BillService;

public class BillController {

	public void doBilling(BillGeneration bill) {
		
		
		BillService service=new BillService();
		service.doBilling(bill);
	}

}

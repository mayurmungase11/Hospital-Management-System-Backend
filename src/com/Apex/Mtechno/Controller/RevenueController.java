package com.Apex.Mtechno.Controller;

import com.Apex.Mtechno.Entity.HospitalRevenue;
import com.Apex.Mtechno.Service.RevenueService;

public class RevenueController {

	public void getRevenue(HospitalRevenue revenue) {
		
		RevenueService service= new RevenueService();
		service.getRevenue(revenue);
		
	}

}

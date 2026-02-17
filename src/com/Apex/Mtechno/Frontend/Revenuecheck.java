package com.Apex.Mtechno.Frontend;

import com.Apex.Mtechno.Controller.RevenueController;
import com.Apex.Mtechno.Entity.HospitalRevenue;

public class Revenuecheck {
	
	public static void main(String[] args) {
		
		
		HospitalRevenue revenue= new HospitalRevenue();
		revenue.setMonth("november");
		
		
		RevenueController controller= new RevenueController();
		controller.getRevenue(revenue);
		
	}

}

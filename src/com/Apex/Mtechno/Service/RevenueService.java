package com.Apex.Mtechno.Service;

import com.Apex.Mtechno.Dao.RevenueDao;
import com.Apex.Mtechno.Entity.HospitalRevenue;

public class RevenueService {

	public void getRevenue(HospitalRevenue revenue) {
		
		RevenueDao dao= new RevenueDao();
		dao.getRevenue(revenue);
	}
}

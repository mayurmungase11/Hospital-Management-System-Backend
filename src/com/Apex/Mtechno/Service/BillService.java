package com.Apex.Mtechno.Service;

import java.time.LocalDateTime;

import com.Apex.Mtechno.Dao.BillDao;
import com.Apex.Mtechno.Entity.BillGeneration;

public class BillService {

	public void doBilling(BillGeneration bill) {
		
		bill.setDateOfGeneration(LocalDateTime.now());
		
		BillDao dao=new BillDao();
		dao.doBilling(bill);
		
	}

}

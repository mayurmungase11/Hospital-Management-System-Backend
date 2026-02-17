package com.Apex.Mtechno.Frontend;

import com.Apex.Mtechno.Controller.BillController;
import com.Apex.Mtechno.Entity.BillGeneration;

public class generateBill {
	public static void main(String[] args) {
		
		BillGeneration bill=new BillGeneration();
		
		bill.setId(74);
		bill.setTotalamount(30000);
		
		BillController controller=new BillController();
		controller.doBilling(bill);
	}

}

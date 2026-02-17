package com.Apex.Mtechno.Service;

import java.time.LocalDate;

import com.Apex.Mtechno.Dao.MedicineDao;
import com.Apex.Mtechno.Entity.MedicineInventory;

public class MedicineService {

	public String manageMedicine(MedicineInventory medicine) {
		
		medicine.setAvailableStock(medicine.getAddedStock());
		if(medicine.getExpirydate().isBefore(LocalDate.now()) || medicine.getExpirydate().isEqual(LocalDate.now())) {
		medicine.setExpiryFlag("Expired..!");
		}
		else {
			medicine.setExpiryFlag("On Going");
		}
		if(medicine.getAvailableStock()>=10)medicine.setStockStatus("Sufficient");
		else if(medicine.getAvailableStock()<=0) medicine.setStockStatus("Stock Ended");
		else medicine.setStockStatus("Low Stock..!");
		medicine.setTotalquantity(medicine.getAddedStock());
		
	
		MedicineDao dao= new MedicineDao();
		Boolean response=dao.manageMedicine(medicine);
		
		if(response)return "Successful Updation";
		else return "failed";
	}

}

package com.Apex.Mtechno.Frontend;

import java.time.LocalDate;

import com.Apex.Mtechno.Controller.MedicineController;
import com.Apex.Mtechno.Entity.MedicineInventory;

public class StoreManager {
	
	public static void main(String[] args) {
		
		MedicineInventory medicine=new MedicineInventory();
		
		medicine.setId(5);
		medicine.setName("Cold&flu-500");
		medicine.setMRP_perQuantity(12.89);
		medicine.setExpirydate(LocalDate.of(2026, 10, 15));
		medicine.setAddedStock(3000);
		
		
		MedicineController controller=new MedicineController();
		String response=controller.manageMedicine(medicine);
		
		System.out.println(response);
	}

}

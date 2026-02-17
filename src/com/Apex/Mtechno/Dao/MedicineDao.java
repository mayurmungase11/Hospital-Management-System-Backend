package com.Apex.Mtechno.Dao;

import java.time.LocalDate;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

import com.Apex.Mtechno.Entity.MedicineInventory;

public class MedicineDao {

	public Boolean manageMedicine(MedicineInventory medicine){


		Configuration cfg=new Configuration();
		cfg.configure();
		cfg.addAnnotatedClass(MedicineInventory.class);
		SessionFactory sf=cfg.buildSessionFactory();
		Session session=sf.openSession();
		
		Criteria criteria=session.createCriteria(MedicineInventory.class);
		criteria.add(Restrictions.eq("expirydate", LocalDate.now()));
		List<MedicineInventory> emedicine=criteria.list();
		for (MedicineInventory existmedicine : emedicine) {
			
			existmedicine.setExpiryFlag("Expired..!");
			}
		
		MedicineInventory existingMedicine=session.get(MedicineInventory.class, medicine.getId());
		
		if(existingMedicine!=null) {
			
			boolean result=true;
			
			if(medicine.getAddedStock()>0) {
        int total=existingMedicine.getTotalquantity()+medicine.getAddedStock();
        existingMedicine.setTotalquantity(total);
        
        int readding=existingMedicine.getAvailableStock()+medicine.getAddedStock();
		existingMedicine.setAvailableStock(readding);
		
		existingMedicine.setAddedStock(medicine.getAddedStock());
			}
			
			
			if(medicine.getSellQuantity()>=0 && medicine.getSellQuantity()<=existingMedicine.getAvailableStock()) {
			int availablestock=existingMedicine.getAvailableStock()-medicine.getSellQuantity();
			   if(availablestock>=0)existingMedicine.setAvailableStock(availablestock);
			
			
			int sell=existingMedicine.getSellQuantity()+medicine.getSellQuantity();
			   existingMedicine.setSellQuantity(sell);
			
			}
			else {
				System.out.println("Insufficient Stock...!");
				result=false;
			}
			
			if(existingMedicine.getExpirydate().isBefore(LocalDate.now()) || existingMedicine.getExpirydate().isEqual(LocalDate.now())) {
				existingMedicine.setExpiryFlag("Expired..!");
			}

			
		if(medicine.getMRP_perQuantity()!=0)existingMedicine.setMRP_perQuantity(medicine.getMRP_perQuantity());
			
		if(medicine.getName()!=null)existingMedicine.setName(medicine.getName());

		
		if(existingMedicine.getAvailableStock()<10)existingMedicine.setStockStatus("Low Stock..!");
		if(existingMedicine.getAvailableStock()<=0)existingMedicine.setStockStatus("Stock Ended..!");
		
		if(result) {
			session.update(existingMedicine);
			session.beginTransaction().commit();
			session.close();
			return true;
		}
		
		}
		else {
			if(medicine.getId()!=0 && medicine.getName()!=null && medicine.getExpirydate()!=null && medicine.getMRP_perQuantity()!=0) {
				
		session.save(medicine);
		session.beginTransaction().commit();
		session.close();
		return true;
			}
			
		else {
				session.beginTransaction().commit();
				session.close();
				return false;
				}
		}

   return true;
}
}

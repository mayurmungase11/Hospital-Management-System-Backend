package com.Apex.Mtechno.Entity;

import java.time.LocalDate;

import javax.persistence.Entity;

import javax.persistence.Id;

@Entity
public class MedicineInventory {
	
	@Id
	
	private int id;
	private String name;
	private LocalDate expirydate;
	private double MRP_perQuantity;
	private int Totalquantity;
	private int addedStock;
	private int sellQuantity;
	private int availableStock;
	private String stockStatus;
	private String ExpiryFlag;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public LocalDate getExpirydate() {
		return expirydate;
	}
	public void setExpirydate(LocalDate expirydate) {
		this.expirydate = expirydate;
	}
	public double getMRP_perQuantity() {
		return MRP_perQuantity;
	}
	public void setMRP_perQuantity(double mRP_perQuantity) {
		MRP_perQuantity = mRP_perQuantity;
	}
	public int getTotalquantity() {
		return Totalquantity;
	}
	public void setTotalquantity(int totalquantity) {
		Totalquantity = totalquantity;
	}
	public int getAddedStock() {
		return addedStock;
	}
	public void setAddedStock(int addedStock) {
		this.addedStock = addedStock;
	}
	public int getSellQuantity() {
		return sellQuantity;
	}
	public void setSellQuantity(int sellQuantity) {
		this.sellQuantity = sellQuantity;
	}
	public int getAvailableStock() {
		return availableStock;
	}
	public void setAvailableStock(int availableStock) {
		this.availableStock = availableStock;
	}
	public String getStockStatus() {
		return stockStatus;
	}
	public void setStockStatus(String stockStatus) {
		this.stockStatus = stockStatus;
	}
	public String getExpiryFlag() {
		return ExpiryFlag;
	}
	public void setExpiryFlag(String expiryFlag) {
		ExpiryFlag = expiryFlag;
	}
	@Override
	public String toString() {
		return "MedicineInventory [id=" + id + ", name=" + name + ", expirydate=" + expirydate + ", MRP_perQuantity="
				+ MRP_perQuantity + ", Totalquantity=" + Totalquantity + ", addedStock=" + addedStock
				+ ", sellQuantity=" + sellQuantity + ", availableStock=" + availableStock + ", stockStatus="
				+ stockStatus + ", ExpiryFlag=" + ExpiryFlag + "]";
	}

	

}

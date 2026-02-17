package com.Apex.Mtechno.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class HospitalRevenue {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String month;
	private int noOfPatients;
	private double totalIncome;
	private double totalDiscount;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getMonth() {
		return month;
	}
	public void setMonth(String month) {
		this.month = month;
	}
	public int getNoOfPatients() {
		return noOfPatients;
	}
	public void setNoOfPatients(int noOfPatients) {
		this.noOfPatients = noOfPatients;
	}
	public double getTotalIncome() {
		return totalIncome;
	}
	public void setTotalIncome(double totalIncome) {
		this.totalIncome = totalIncome;
	}
	public double getTotalDiscount() {
		return totalDiscount;
	}
	public void setTotalDiscount(double totalDiscount) {
		this.totalDiscount = totalDiscount;
	}
	@Override
	public String toString() {
		return "HospitalRevenue [id=" + id + ", month=" + month + ", noOfPatients=" + noOfPatients + ", totalIncome="
				+ totalIncome + ", totalDiscount=" + totalDiscount + "]";
	}
	
	

}

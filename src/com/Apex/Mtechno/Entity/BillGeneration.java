package com.Apex.Mtechno.Entity;

import java.time.LocalDateTime;

import javax.persistence.Entity;

import javax.persistence.Id;

@Entity
public class BillGeneration {
	
	@Id
	
	private int billid;
	private String patientname;
	private int patientage;
	private double totalamount;
	private String discount;
	private double payableamount;
	private LocalDateTime dateOfGeneration;
	
	
	
	public int getId() {
		return billid;
	}

	public void setId(int billid) {
		this.billid = billid;
	}

	public String getPatientname() {
		return patientname;
	}

	public void setPatientname(String patientname) {
		this.patientname = patientname;
	}

	public int getPatientage() {
		return patientage;
	}

	public void setPatientage(int patientage) {
		this.patientage = patientage;
	}

	public double getTotalamount() {
		return totalamount;
	}

	public void setTotalamount(double totalamount) {
		this.totalamount = totalamount;
	}

	public String getDiscount() {
		return discount;
	}

	public void setDiscount(String discount) {
		this.discount = discount;
	}

	public double getPayableamount() {
		return payableamount;
	}

	public void setPayableamount(double payableamount) {
		this.payableamount = payableamount;
	}

	public LocalDateTime getDateOfGeneration() {
		return dateOfGeneration;
	}

	public void setDateOfGeneration(LocalDateTime dateOfGeneration) {
		this.dateOfGeneration = dateOfGeneration;
	}

	

	@Override
	public String toString() {
		return "BillGeneration [billid=" + billid + ", patientname=" + patientname + ", patientage=" + patientage
				+ ", totalamount=" + totalamount + ", discount=" + discount + ", payableamount=" + payableamount
				+ ", dateOfGeneration=" + dateOfGeneration + "]";
	}
	
	
	

}

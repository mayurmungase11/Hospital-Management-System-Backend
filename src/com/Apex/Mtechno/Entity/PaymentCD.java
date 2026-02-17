package com.Apex.Mtechno.Entity;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.Id;
@Entity
public class PaymentCD {
	@Id
	private int patientid;
	private int amount;
	private String status;
	private LocalDateTime dateOfPayment;
	private int refundamount;
	private String refundStatus;
	private LocalDateTime dateOfRefund;
	

	public int getPatientid() {
		return patientid;
	}
	public void setPatientid(int patientid) {
		this.patientid = patientid;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public LocalDateTime getDateOfPayment() {
		return dateOfPayment;
	}
	public void setDateOfPayment(LocalDateTime dateOfPayment) {
		this.dateOfPayment = dateOfPayment;
	}
	
	
	public int getRefundamount() {
		return refundamount;
	}
	public void setRefundamount(int refundamount) {
		this.refundamount = refundamount;
	}
	public String getRefundStatus() {
		return refundStatus;
	}
	public void setRefundStatus(String refundStatus) {
		this.refundStatus = refundStatus;
	}
	public LocalDateTime getDateOfRefund() {
		return dateOfRefund;
	}
	public void setDateOfRefund(LocalDateTime dateOfRefund) {
		this.dateOfRefund = dateOfRefund;
	}
	
	@Override
	public String toString() {
		return "PaymentCD [patientid=" + patientid + ", amount=" + amount + ", status=" + status + ", dateOfPayment="
				+ dateOfPayment + ", refundamount=" + refundamount + ", refundStatus=" + refundStatus
				+ ", dateOfRefund=" + dateOfRefund + "]";
	}
	

}

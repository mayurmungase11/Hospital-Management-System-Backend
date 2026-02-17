package com.Apex.Mtechno.Entity;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class DoctorFeesAudit {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int auditId;
	private int doctorId;
	private int oldFees;
	private int newUpdatedFees;
	private LocalDateTime ChangedAt;
	private String changeBy;
	public int getAuditId() {
		return auditId;
	}
	public void setAuditId(int auditId) {
		this.auditId = auditId;
	}
	public int getDoctorId() {
		return doctorId;
	}
	public void setDoctorId(int doctorId) {
		this.doctorId = doctorId;
	}
	public int getOldFees() {
		return oldFees;
	}
	public void setOldFees(int oldFees) {
		this.oldFees = oldFees;
	}
	public int getNewUpdatedFees() {
		return newUpdatedFees;
	}
	public void setNewUpdatedFees(int newUpdatedFees) {
		this.newUpdatedFees = newUpdatedFees;
	}
	public LocalDateTime getChangedAt() {
		return ChangedAt;
	}
	public void setChangedAt(LocalDateTime changedAt) {
		ChangedAt = changedAt;
	}
	public String getChangeBy() {
		return changeBy;
	}
	public void setChangeBy(String changeBy) {
		this.changeBy = changeBy;
	}
	@Override
	public String toString() {
		return "DoctorFeesAudit [auditId=" + auditId + ", doctorId=" + doctorId + ", oldFees=" + oldFees
				+ ", newUpdatedFees=" + newUpdatedFees + ", ChangedAt=" + ChangedAt + ", changeBy=" + changeBy + "]";
	}
	
	
	

}

package com.Apex.Mtechno.Entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Appointment{
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int apid;
	
	private int id;
	
	private String dr_name;
	private int Consultation_fees;
	private LocalDate date;
	private LocalTime time;
	private String patientname;
	private String mobilenumber;
	private LocalDateTime BookedAppointmentAt;
	private LocalDateTime ModifiedAppointmentAt;
	private Boolean fees_paid;
	private String status;
	
	
	
	
	public int getApid() {
		return apid;
	}
	public void setApid(int apid) {
		this.apid = apid;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDr_name() {
		return dr_name;
	}
	public void setDr_name(String dr_name) {
		this.dr_name = dr_name;
	}
	
	public int getConsultation_fees() {
		return Consultation_fees;
	}
	public void setConsultation_fees(int i) {
		Consultation_fees = i;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public LocalTime getTime() {
		return time;
	}
	public void setTime(LocalTime time) {
		this.time = time;
	}
	public String getPatientname() {
		return patientname;
	}
	public void setPatientname(String patientname) {
		this.patientname = patientname;
	}
	public String getMobilenumber() {
		return mobilenumber;
	}
	public void setMobilenumber(String mobilenumber) {
		this.mobilenumber = mobilenumber;
	}
	public LocalDateTime getBookedAppointmentAt() {
		return BookedAppointmentAt;
	}
	public void setBookedAppointmentAt(LocalDateTime bookedAppointmentAt) {
		BookedAppointmentAt = bookedAppointmentAt;
	}
	public LocalDateTime getModifiedAppointmentAt() {
		return ModifiedAppointmentAt;
	}
	public void setModifiedAppointmentAt(LocalDateTime modifiedAppointmentAt) {
		ModifiedAppointmentAt = modifiedAppointmentAt;
	}
	public Boolean getFees_paid() {
		return fees_paid;
	}
	public void setFees_paid(Boolean fees_paid) {
	 
		this.fees_paid = fees_paid;
	     }
	
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		
		this.status = status;
	}
	
	
	
	@Override
	public String toString() {
		return "Appointment [apid=" + apid + ", id=" + id + ", dr_name=" + dr_name + ", Consultation_fees="
				+ Consultation_fees + ", date=" + date + ", time=" + time + ", patientname=" + patientname
				+ ", mobilenumber=" + mobilenumber + ", BookedAppointmentAt=" + BookedAppointmentAt
				+ ", ModifiedAppointmentAt=" + ModifiedAppointmentAt + ", fees_paid=" + fees_paid + ", status=" + status
				+ "]";
	}
	
	
  
}

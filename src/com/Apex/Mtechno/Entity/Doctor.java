package com.Apex.Mtechno.Entity;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class Doctor {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private int id;
	private String name;
	private String specialization;
	private String Qualification;
	private int consulatation_fees;
	private int experience;
	private String email;
	private String mobilenumber;
	private String password;
	private String Status;
	private LocalDateTime dateofCreation;
	private LocalDateTime dateOfModification;
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
	public String getSpecialization() {
		return specialization;
	}
	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}
	public String getQualification() {
		return Qualification;
	}
	public void setQualification(String qualification) {
		Qualification = qualification;
	}
	public int getConsulatation_fees() {
		return consulatation_fees;
	}
	public void setConsulatation_fees(int consulatation_fees) {
		this.consulatation_fees = consulatation_fees;
	}
	public int getExperience() {
		return experience;
	}
	public void setExperience(int experience) {
		this.experience = experience;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMobilenumber() {
		return mobilenumber;
	}
	public void setMobilenumber(String mobilenumber) {
		this.mobilenumber = mobilenumber;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getStatus() {
		return Status;
	}
	public void setStatus(String status) {
		Status = status;
	}
	public LocalDateTime getDateofCreation() {
		return dateofCreation;
	}
	public void setDateofCreation(LocalDateTime dateofCreation) {
		this.dateofCreation = dateofCreation;
	}
	public LocalDateTime getDateOfModification() {
		return dateOfModification;
	}
	public void setDateOfModification(LocalDateTime dateOfModification) {
		this.dateOfModification = dateOfModification;
	}
	@Override
	public String toString() {
		return "Doctor [id=" + id + ", name=" + name + ", specialization=" + specialization + ", Qualification="
				+ Qualification + ", consulatation_fees=" + consulatation_fees + ", experience=" + experience
				+ ", email=" + email + ", mobilenumber=" + mobilenumber + ", password=" + password + ", Status="
				+ Status + ", dateofCreation=" + dateofCreation + ", dateOfModification=" + dateOfModification + "]";
	}

	
}

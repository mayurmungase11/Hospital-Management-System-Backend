package com.Apex.Mtechno.Entity;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Patient {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private int id;
	private String fullname;
	private String mobilenumber;
	private String email;
	private String username;
	private String password;
	private String DOB;
	private int age;
	private LocalDateTime dateOfCreation;
	private LocalDateTime dateOfModification;
	private String AccountStatus;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFullname() {
		return fullname;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	public String getMobilenumber() {
		return mobilenumber;
	}
	public void setMobilenumber(String mobilenumber) {
		this.mobilenumber = mobilenumber;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getDOB() {
		return DOB;
	}
	public void setDOB(String dOB) {
		DOB = dOB;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public LocalDateTime getDateOfCreation() {
		return dateOfCreation;
	}
	public void setDateOfCreation(LocalDateTime localDateTime) {
		this.dateOfCreation = localDateTime;
	}
	public LocalDateTime getDateOfModification() {
		return dateOfModification;
	}
	public void setDateOfModification(LocalDateTime localDateTime) {
		this.dateOfModification = localDateTime;
	}
	
	public String getAccountStatus() {
		return AccountStatus;
	}
	public void setAccountStatus(String AccountStatus) {
		this.AccountStatus = AccountStatus;
	}
	@Override
	public String toString() {
		return "Patient [id=" + id + ", fullname=" + fullname + ", mobilenumber=" + mobilenumber + ", email=" + email
				+ ", username=" + username + ", password=" + password + ", DOB=" + DOB + ", age=" + age
				+ ", dateOfCreation=" + dateOfCreation + ", dateOfModification=" + dateOfModification + ", AccountStatus="
				+ AccountStatus + "]";
	}
	
	
	
	

}

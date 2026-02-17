package com.Apex.Mtechno.Entity;

import javax.persistence.Entity;

import javax.persistence.Id;

@Entity
public class Login {
	
	@Id
	
	private int id;
	private int failedAttempts;
	private long lockedtime;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getFailedAttempts() {
		return failedAttempts;
	}
	public void setFailedAttempts(int failedAttempts) {
		this.failedAttempts = failedAttempts;
	}
	public long getLockedtime() {
		return lockedtime;
	}
	public void setLockedtime(long lockedtime) {
		this.lockedtime = lockedtime;
	}
	@Override
	public String toString() {
		return "Login [id=" + id + ", failedAttempts=" + failedAttempts + ", lockedtime=" + lockedtime + "]";
	}
	
	
	
}
	
	
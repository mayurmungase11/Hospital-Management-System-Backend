package com.Apex.Mtechno.Service;

import com.Apex.Mtechno.Entity.Login;

public class PauseLogin {
	
	
	Login l=new Login();
	
	public void stopLogin(int min,int attempts) {
		
		long lockedtime=l.getLockedtime();
		long currenttime=System.currentTimeMillis();
		long difference=currenttime-lockedtime;
		
		if(difference>min*60*1000) {
			
			l.setLockedtime(0);
			l.setFailedAttempts(0);
			
		}
		else {
			System.out.println("Account is loked for "+min+"minutes..try later");
			lockedtime=System.currentTimeMillis();
			l.setLockedtime(lockedtime);
			
		}
		
		
	}

}

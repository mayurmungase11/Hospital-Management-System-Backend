package com.Apex.Mtechno.Service;

import com.Apex.Mtechno.Entity.Patient;


public class Validation {
	
	boolean emailchecking(Patient patient) {
		String enteredmail=patient.getEmail();
		boolean b=enteredmail.contains("@");
		
		if(b)return true;
		else {
			System.out.println("Email must be required "+"@"+"Character");
			return false;
		}
	}
	
	boolean passachecking(Patient patient) {

	      boolean result=false;
			String pass=patient.getPassword();
			
			
			boolean isUpper=false;
			boolean isLower=false;
			boolean isDigit=false;
			boolean specialChar=false;
			
			if(pass.length()>8) {
				System.out.println("password size Exceed... ");
				
			    }
			
			else {
			for (int i=0;i<pass.length();i++) {
				
				
				
				char c=pass.charAt(i);
				
				if(Character.isUpperCase(c)) {
					isUpper=true;
				}
				else if(Character.isLowerCase(c)) {
					isLower=true;
				}
				else if(Character.isDigit(c)) {
					isDigit=true;
				}
				else {
					specialChar=true;
				}
				
			}
			
			if(isUpper&&isLower&&isDigit&&specialChar) {
				
				result=true;
			}
			else {
				System.out.println("please Set Strong password ....must contains Uppercase,Lowercase,Digit& atleast one SpecialCharacter");
			
			}
			}
			if(result)return true;
			else return false;
			
}
	public boolean contactsize(Patient patient) {
		
		String number=patient.getMobilenumber();
		if(number.length()==10) {
			return true;
		}
		else {
			System.out.println("Mobile number must be required 10 digits");
			return false;
		}
		
	}
}

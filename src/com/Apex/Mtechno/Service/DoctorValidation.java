package com.Apex.Mtechno.Service;

import com.Apex.Mtechno.Entity.Doctor;


public class DoctorValidation {
	
	public boolean checkValidation(Doctor doctor) {
		
		
        if(doctor.getConsulatation_fees()>=500 && doctor.getConsulatation_fees()<=5000) {
        	
        	if(doctor.getExperience()>=1) return true; 
        	else {
        		System.out.println("Experience must be required Minimum 1 year..");
        		return false;
        	}
			
		}
		else {System.out.println("consulatation fees required in between 500-5000 only..! please check it");}
		
	 return false;
	 }
	
	boolean emailchecking(Doctor doctor) {
		
		String enteredmail=doctor.getEmail();
		if(enteredmail!=null) {
		boolean b=enteredmail.contains("@");
		
		if(b)return true;
		else {
			System.out.println("Email must be required "+"@"+"Character");
			return false;
		}
		}
		else {
			System.out.println("Email must be required");
			return false;
		}
	}
	
	boolean passachecking(Doctor doctor) {

	      boolean result=false;
			String pass=doctor.getPassword();
			
			
			boolean isUpper=false;
			boolean isLower=false;
			boolean isDigit=false;
			boolean specialChar=false;
			
			if(pass.length()>10) {
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
	public boolean contactsize(Doctor doctor) {
		
		String number=doctor.getMobilenumber();
		if(number.length()==10) {
			return true;
		}
		else {
			System.out.println("Mobile number must be required 10 digits");
			return false;
		}
		
	}
}
	

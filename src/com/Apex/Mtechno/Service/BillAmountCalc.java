package com.Apex.Mtechno.Service;

import com.Apex.Mtechno.Entity.BillGeneration;

public class BillAmountCalc {

	public String generateFinalBill(BillGeneration bill) {

          double totalAmount=bill.getTotalamount();
          
          
          if(bill.getPatientage()>=60) {
        	  
        	  bill.setDiscount("15%");
        	  
        	  double discount=(totalAmount*15)/100;
        	  double paybleAmount=totalAmount-discount;
        	    
        	  bill.setPayableamount(paybleAmount);
        	  
          }
        	  else if(totalAmount>1000){
        		  
        		  bill.setDiscount("5%");
            	  
            	  double discount=(totalAmount*5)/100;
            	   double paybleAmount=totalAmount-discount;
            	   
            	  bill.setPayableamount(paybleAmount);
        		  
        	  }
        	  
    
          else {
        	  
        	  bill.setPayableamount(totalAmount);
        	  
        	  
          }
          
          StringBuilder receipt = new StringBuilder();
          
          receipt.append("******** Final Bill ********\n");
          receipt.append("Bill/Appointment  ID: ").append(bill.getId()).append("\n");
          receipt.append("Patient Name: ").append(bill.getPatientname()).append("\n");
          receipt.append("Patient age").append(bill.getPatientage()).append("\n");
          receipt.append("Total amount: ").append(bill.getTotalamount()).append("\n");
          receipt.append("Total Discount %: ").append(bill.getDiscount()).append("\n");
          receipt.append("Total PaybleAmount: ").append(bill.getPayableamount()).append("\n");
          receipt.append("DateTime: ").append(bill.getDateOfGeneration()).append("\n");
          receipt.append("*********************************\n");
          
          return receipt.toString();
		
		
	}

}

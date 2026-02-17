package com.Apex.Mtechno.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import com.Apex.Mtechno.Entity.Appointment;
import com.Apex.Mtechno.Entity.PaymentCD;

public class RefundSet {
	
	public void doRefund(PaymentCD payment,Appointment ap) {
		
		int fees=payment.getAmount();
		LocalDate apDate=ap.getDate();
		LocalTime apTime=ap.getTime();
		
		LocalDate currentDate=LocalDate.now();
		LocalTime currentTime=LocalTime.now();
		
		if(apDate.isBefore(currentDate)) {
			
			int refundamount=(fees*80)/100;
			
			// do refund refundamount by Gpay 
			
			payment.setRefundamount(refundamount);
			payment.setDateOfRefund(LocalDateTime.now());
			payment.setRefundStatus("Refunded");
			
		}
		else {
			payment.setRefundamount(0);
			payment.setDateOfRefund(LocalDateTime.now());
			payment.setRefundStatus("Not Eligible");
		}
		
		
		
	}

}

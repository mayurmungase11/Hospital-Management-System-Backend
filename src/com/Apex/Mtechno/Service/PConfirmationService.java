package com.Apex.Mtechno.Service;

import java.time.LocalDateTime;

import com.Apex.Mtechno.Dao.PConfirmationDao;
import com.Apex.Mtechno.Entity.Appointment;
import com.Apex.Mtechno.Entity.PaymentCD;

public class PConfirmationService {

	public void doConfirm(PaymentCD appointment) {
		
		//checking payment debited or not from payment gateway
		
		//if payment success then do the following operations 
		
		
		appointment.setDateOfPayment(LocalDateTime.now());
		
		PConfirmationDao dao=new PConfirmationDao();
		dao.doConfirm(appointment);
	}

}

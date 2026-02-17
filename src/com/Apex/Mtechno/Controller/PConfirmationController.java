package com.Apex.Mtechno.Controller;


import com.Apex.Mtechno.Entity.PaymentCD;
import com.Apex.Mtechno.Service.PConfirmationService;

public class PConfirmationController {

	public void doConfirm(PaymentCD appointment) {
		
		
		PConfirmationService service=new PConfirmationService();
		service.doConfirm(appointment);
		
	}

}

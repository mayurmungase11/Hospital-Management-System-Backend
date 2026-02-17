package com.Apex.Mtechno.Service;

import com.Apex.Mtechno.Entity.Appointment;
import com.Apex.Mtechno.Entity.Doctor;
import com.Apex.Mtechno.Entity.PaymentCD;

public class PaymentDetails {

	public String paymentReceipt(PaymentCD appointment,Appointment patient,Doctor dr) {
		
		System.out.println("********Payment Recipt********");
		System.out.println("Appointment ID:"+appointment.getPatientid());
		System.out.println("Patient Name:"+patient.getPatientname());
		System.out.println("Fees Paid:"+dr.getConsulatation_fees());
		System.out.println("Payment DateTime:"+appointment.getDateOfPayment());
		
StringBuilder receipt = new StringBuilder();
        
        receipt.append("******** Payment Receipt ********\n");
        receipt.append("Appointment ID: ").append(appointment.getPatientid()).append("\n");
        receipt.append("Patient Name: ").append(patient.getPatientname()).append("\n");
        receipt.append("Fees Paid: ").append(patient.getFees_paid()).append("\n");
        receipt.append("Payment DateTime: ").append(appointment.getDateOfPayment()).append("\n");
        receipt.append("*********************************\n");
        
        return receipt.toString();
    	
	}

}

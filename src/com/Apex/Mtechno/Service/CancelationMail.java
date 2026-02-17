package com.Apex.Mtechno.Service;


	import java.util.Properties;

	import javax.mail.Authenticator;
	import javax.mail.Message;
	import javax.mail.MessagingException;
	import javax.mail.PasswordAuthentication;
	import javax.mail.Session;
	import javax.mail.Transport;
	import javax.mail.internet.InternetAddress;
	import javax.mail.internet.MimeMessage;

import com.Apex.Mtechno.Entity.Appointment;
import com.Apex.Mtechno.Entity.Doctor;
import com.Apex.Mtechno.Entity.Patient;

	public class CancelationMail {
		
		public void gmailtoPatient(Patient patient){
			String recipientEmail=patient.getEmail();
			
			
	        // Sender's email credentials
	        final String senderEmail = "mayurmungase9518@gmail.com";
	        final String senderPassword = "pdct ttpz iqmu mkec"; // Use App Password if using Gmail

	        // SMTP server settings
	        Properties props = new Properties();
	        props.put("mail.smtp.host", "smtp.gmail.com");
	        props.put("mail.smtp.port", "587");
	        props.put("mail.smtp.auth", "true");
	        props.put("mail.smtp.starttls.enable", "true");
	        props.put("mail.smtp.ssl.protocols", "TLSv1.2");
	        props.put("mail.smtp.ssl.trust", "smtp.gmail.com");

	        // Create session
	        Session session = Session.getInstance(props, new Authenticator() {
	            protected PasswordAuthentication getPasswordAuthentication() {
	                return new PasswordAuthentication("mayurmungase9518@gmail.com", "pdct ttpz iqmu mkec");
	            }
	        });

	        try {
	        	
	            // Compose the message
	            Message message = new MimeMessage(session);
	            message.setFrom(new InternetAddress(senderEmail));
	            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(recipientEmail));
	            message.setSubject("Apex Multispecialist Hospital.." +"Appointment Cancelled..!");
	           
	            
	            message.setText("Your PatientID is: "+patient.getId()+" ,"
	            +"Appointment Status:"+"Cancelled" +" ,"
	            +"Refund:"+"If you cancelled appointment before 24hrs of sheduled then 80% of fees Refunded successfully"
	            		+ "Otherwise Not Eligible for Refund");
	            
	            // Send the message
	            Transport.send(message);
	            System.out.println("Appointment Cancelled creditails sent successfully to " + recipientEmail);

	        } catch (MessagingException e) {
	            e.printStackTrace();
	        }
	       
	    }
		
		
		
		public void gmailtoDoctor(Doctor dr,Appointment appointment){
			String recipientEmail=dr.getEmail();
			
			
	        // Sender's email credentials
	        final String senderEmail = "mayurmungase9518@gmail.com";
	        final String senderPassword = "pdct ttpz iqmu mkec"; // Use App Password if using Gmail

	        // SMTP server settings
	        Properties props = new Properties();
	        props.put("mail.smtp.host", "smtp.gmail.com");
	        props.put("mail.smtp.port", "587");
	        props.put("mail.smtp.auth", "true");
	        props.put("mail.smtp.starttls.enable", "true");

	        // Create session
	        Session session = Session.getInstance(props, new Authenticator() {
	            protected PasswordAuthentication getPasswordAuthentication() {
	                return new PasswordAuthentication("mayurmungase9518@gmail.com", "pdct ttpz iqmu mkec");
	            }
	        });

	        try {
	        	
	            // Compose the message
	            Message message = new MimeMessage(session);
	            message.setFrom(new InternetAddress(senderEmail));
	            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(recipientEmail));
	            message.setSubject("Apex Multispecialist Hospital.." +"Patient Appointment Cancelled..!");
	           
	            
	            message.setText("Your AppointmentID is: "+appointment.getId()+" ,"
	            +"Appointment Status:"+"Cancelled" +" ,"
	            		+"AppointmentDate: "+appointment.getDate()+" ,"
	            				+"AppointmentDate: "+appointment.getTime()+" ,"
	            +"Refund:"+"Refunded if eligible");
	            
	            // Send the message
	            Transport.send(message);
	            System.out.println("Appointment Cancelled creditails sent successfully to " + recipientEmail);

	        } catch (MessagingException e) {
	            e.printStackTrace();
	        }
	       
	    }
	}


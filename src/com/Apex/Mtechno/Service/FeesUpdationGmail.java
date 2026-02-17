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

import com.Apex.Mtechno.Entity.Doctor;
import com.Apex.Mtechno.Entity.DoctorFeesAudit;


	public class FeesUpdationGmail {
		
		public void gmailToDoctor(Doctor doctor,DoctorFeesAudit audit){
			String recipientEmail=doctor.getEmail();
			
			
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
	            message.setSubject("Welcome to Apex Multispecialist Hospital.." +"Your Consultation Fees Changed..!");
	           
	            
	            message.setText("Changed By: "+audit.getChangeBy()+"\n"+
	            		"Your DoctorID: "+audit.getDoctorId()+"\n"+
	            		"Your Old Cosultation_Fees: "+audit.getOldFees()+"\n"
	            +"Your New Updated Fees :"+audit.getNewUpdatedFees()+"\n"
	            +"ChangeAt:"+audit.getChangedAt());
	            
	            // Send the message
	            Transport.send(message);
	            System.out.println("Fees Updated creditails sent successfully to " + recipientEmail);

	        } catch (MessagingException e) {
	            e.printStackTrace();
	        }
	       
	    }
	}



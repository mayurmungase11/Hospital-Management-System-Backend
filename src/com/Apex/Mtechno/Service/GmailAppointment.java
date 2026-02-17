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

	public class GmailAppointment {
		
		public void gmailToPatient(Appointment appointment ,Patient patient,int apID,int fees){
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
	            message.setSubject("Welcome to Apex Multispecialist Hospital.."+" "
	            +"Your Appointment Booked Successfully...!");
	           
	            
	            message.setText("Your AppointmentID is: "+apID+" "
	            +"Doctorname:"+appointment.getDr_name()+" "
	            +"Appointment Date:"+appointment.getDate()+" "
	            +"Appointment Time :"+appointment.getTime()+" "
	            +"Doctor_fees :"+fees);
	            
	            // Send the message
	            Transport.send(message);
	            System.out.println("Appointment details sent successfully to patient " + recipientEmail);

	        } catch (MessagingException e) {
	            e.printStackTrace();
	        }
	       
	    }
		
		public void gmailToDoctor(Appointment appointment,Doctor doctor){
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
	            message.setSubject("Welcome to Apex Multispecialist Hospital.."+" "
	            +"  One more Appointment Added");
	           
	            
	            message.setText(
	            "Patientname:"+appointment.getPatientname()+" "
	            +"Appointment Date:"+appointment.getDate()+" "
	            +"Appointment Time :"+appointment.getTime()
	            );
	            
	            // Send the message
	            Transport.send(message);
	            System.out.println("Appointment details sent to doctor" + recipientEmail);

	        } catch (MessagingException e) {
	            e.printStackTrace();
	        }
	       
	    }
	}


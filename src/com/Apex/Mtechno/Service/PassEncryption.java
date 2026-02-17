package com.Apex.Mtechno.Service;

import java.security.MessageDigest;

public class PassEncryption {

    public String passwordEncryption(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hash = md.digest(password.getBytes());

            // convert bytes to hex string
            StringBuilder sb = new StringBuilder();
            for (byte b : hash) {
                sb.append(String.format("%02x", b));
            }
            return sb.toString();

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
package com.shop.service;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.PasswordAuthentication;
import java.util.Properties;

public class SendEmail {
    private String userEmail;
    private String hash;
    String email = "minhthong23501@gmail.com"; // sender email
    String password = "qkuqamdpaxmeluba"; // sender password
    public SendEmail(String userEmail, String hash) {
        super();
        this.userEmail = userEmail;
        this.hash = hash;
    }
    public void sendMailActivate()
    {
        Properties properties = new Properties();
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587");


        Session session = Session.getInstance(properties, new javax.mail.Authenticator(){
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(email, password);
                }
            });


        try {
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(email, "Shop"));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(userEmail));
            message.setText("Verification Link....");
            message.setText("Click Here :: "+
                    "http://localhost:8080/shop_war/AccountActivate?key1="
                    +userEmail+"&key2="+hash);
            Transport.send(message);

        }catch(Exception e){
            System.out.println("SendEmail File Error"+ e);
        }
    }
    public void sendMailForgot()
    {
        Properties properties1 = new Properties();
        properties1.put("mail.smtp.auth", "true");
        properties1.put("mail.smtp.starttls.enable", "true");
        properties1.put("mail.smtp.host", "smtp.gmail.com");
        properties1.put("mail.smtp.port", "587");


        Session session1 = Session.getInstance(properties1, new javax.mail.Authenticator(){
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(email, password);
            }
        });


        try {
            MimeMessage message1 = new MimeMessage(session1);
            message1.setFrom(new InternetAddress(email, "Shop"));
            message1.addRecipient(Message.RecipientType.TO, new InternetAddress(userEmail));
            message1.setText("Password....");
            message1.setText("Password is:: "+hash);
            Transport.send(message1);

        }catch(Exception e){
            System.out.println("SendEmail File Error"+ e);
        }
    }
}


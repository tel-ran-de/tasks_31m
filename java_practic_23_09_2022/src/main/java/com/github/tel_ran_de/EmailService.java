package com.github.tel_ran_de;

import java.util.HashMap;
import java.util.Map;

public class EmailService {
    private Map<String, Integer> sendedEmails = new HashMap<>();

    public void sendEmail(String email, String emailBody) {
        if(!sendedEmails.containsKey(email)) {
            System.out.println(email + " : " + emailBody);
            sendedEmails.put(email, 1);
        }
        if(sendedEmails.get(email) == 1) {
            System.out.println(email + " : " + "Last reminder! " + emailBody);
            sendedEmails.put(email, 2);
        }
    }

    public static void main(String[] args) {
        EmailService emailService = new EmailService();

        emailService.sendEmail("test@gmail.com", "Hi!");
        emailService.sendEmail("test11@gmail.com", "Hi!");
        emailService.sendEmail("test11@gmail.com", "Hi!");
        emailService.sendEmail("test@gmail.com", "Hi!");
        emailService.sendEmail("test@gmail.com", "Hi!");
        emailService.sendEmail("test11@gmail.com", "Hi!");
        emailService.sendEmail("test11@gmail.com", "Hi!");
    }
}

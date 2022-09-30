package com.github.tel_ran_de.practic3009.task3;

import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import java.util.function.Predicate;

public class EmailValidationSerivce {
    private final static GmailService gmailService = new GmailService();
    private final static YandexService yandexService = new YandexService();
    private final static Map<String, Predicate<String>> VALIDATE_MAP = new LinkedHashMap<>();
    static {
        VALIDATE_MAP.put(
                "gmail.com", email -> gmailService.validate(email)
        );
        VALIDATE_MAP.put(
                "yandex.com", email -> yandexService.validate(email)
        );
    }

    public boolean validate(String email) {
        String trimmedStr = email.trim().toLowerCase(Locale.ROOT);

        for(String domain: VALIDATE_MAP.keySet()) {
            if(trimmedStr.endsWith(domain)) {
                Predicate<String> predicate = VALIDATE_MAP.get(domain);
                return predicate.test(email);
            }
        }
        System.out.println("Check other email " + email);
        return email.contains("@");

        /*
        if(trimmedStr.endsWith("gmail.com")) {
            return gmailService.validate(email);
        } else if(trimmedStr.endsWith("yandex.com")) {
            return yandexService.validate(email);
        } else {
            System.out.println("Check other email " + email);
            return email.contains("@");
        }
         */
    }

    public static void main(String[] args) {
        //String email = "slava@gMaIl.com ".trim().toLowerCase(Locale.ROOT);
        //System.out.println(email.endsWith("gmail.com"));

        EmailValidationSerivce emailValidationSerivce = new EmailValidationSerivce();
        emailValidationSerivce.validate("slava@gmail.com");
        emailValidationSerivce.validate("slava@yandex.com");
        emailValidationSerivce.validate("slava@test.com");
    }
}

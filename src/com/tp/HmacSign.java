package com.tp;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class HmacSign {
    public static void main(String[] args) throws NoSuchAlgorithmException, InvalidKeyException {
        String document = "MSGdocument";
        String secret = "Laraki@123";
        SecretKeySpec secretKeySpec = new SecretKeySpec(secret.getBytes(),"HmacSHA256");
        Mac mac = Mac.getInstance("HmacSHA256");
        mac.init(secretKeySpec);
        byte[] signature= mac.doFinal(document.getBytes());
        System.out.println("**** signature ******");
        System.out.println(Base64.getEncoder().encodeToString(signature));
        System.out.println("***** verify signature *******");
    }
}
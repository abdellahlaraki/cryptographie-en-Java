package com.tp;


import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

public class HmacVerify {
    public static void main(String[] args) throws Exception {
        String receivedDoc = "MSGdocument" + "---__" + "wdHNYfgiajAKmd7cYnQzcM4YwOiRqOPntB3is/dEa00=";
        String [] spliteDoc= receivedDoc.split("---__");
        String receivedSignature=spliteDoc[1];
        String document = spliteDoc[0];
        String secret1="Laraki@123";
        SecretKeySpec secretKeySpec1= new SecretKeySpec(secret1.getBytes(),"HmacSHA256");
        Mac mac1=Mac.getInstance("HmacSHA256");
        mac1.init(secretKeySpec1);
        byte[] signature1=mac1.doFinal(document.getBytes());
        String calculatedSignature = Base64.getEncoder().encodeToString(signature1);
        System.out.println(receivedSignature.equals(calculatedSignature)?"Signatur OK" : "Signature non OK");
    }
}
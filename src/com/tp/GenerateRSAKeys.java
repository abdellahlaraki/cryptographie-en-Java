package com.tp;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.Base64;

public class GenerateRSAKeys {
    public static void main(String[] args) throws Exception {

        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
        keyPairGenerator.initialize(512);
        KeyPair keyPair= keyPairGenerator.generateKeyPair();


        PrivateKey privateKey = keyPair.getPrivate();
        String encodedPrivateKey = Base64.getEncoder().encodeToString(privateKey.getEncoded());
        System.out.println("* private key *");
        System.out.println(encodedPrivateKey);
        PublicKey publicKey = keyPair.getPublic();
        String encodedPublickey = Base64.getEncoder().encodeToString(publicKey.getEncoded());
        System.out.println("* public key **");
        System.out.println(encodedPublickey);
    }
}
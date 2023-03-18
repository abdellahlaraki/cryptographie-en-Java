package com.tp;

import javax.crypto.Cipher;
import java.io.FileInputStream;
import java.nio.charset.StandardCharsets;
import java.security.KeyStore;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.cert.Certificate;
import java.security.cert.CertificateFactory;

public class CertificateApp {
    public static void main(String[] args) throws Exception {
        // Charger la clé privée à partir du fichier mundiapolis.jks
        KeyStore keyStore = KeyStore.getInstance(KeyStore.getDefaultType());
        char[] password = "Laraki@123".toCharArray();
        FileInputStream fileInputStream = new FileInputStream("mundiapolis.jks");
        keyStore.load(fileInputStream, password);
        PrivateKey privateKey = (PrivateKey) keyStore.getKey("mundiapolis", password);

        // Charger la clé publique à partir du fichier certificate.cert
        FileInputStream fis = new FileInputStream("certificate.cert");
        Certificate cert = CertificateFactory.getInstance("X.509").generateCertificate(fis);
        PublicKey publicKey = cert.getPublicKey();

        // Crypter un message avec la clé publique
        String plainText = "Message en clair";
        byte[] encryptedText = encrypt(plainText, publicKey);
        System.out.println("Texte chiffré : " + new String(encryptedText, StandardCharsets.UTF_8));

        // Déchiffrer le message avec la clé privée
        String decryptedText = decrypt(encryptedText, privateKey);
        System.out.println("Texte déchiffré : " + decryptedText);
    }

    public static byte[] encrypt(String plainText, PublicKey publicKey) throws Exception {
        Cipher cipher = Cipher.getInstance("RSA/ECB/OAEPWithSHA-256AndMGF1Padding");
        cipher.init(Cipher.ENCRYPT_MODE, publicKey);
        byte[] encryptedText = cipher.doFinal(plainText.getBytes());
        return encryptedText;
    }

    public static String decrypt(byte[] encryptedText, PrivateKey privateKey) throws Exception {
        Cipher cipher = Cipher.getInstance("RSA/ECB/OAEPWithSHA-256AndMGF1Padding");
        cipher.init(Cipher.DECRYPT_MODE, privateKey);
        byte[] decryptedText = cipher.doFinal(encryptedText);
        return new String(decryptedText, StandardCharsets.UTF_8);
    }
}
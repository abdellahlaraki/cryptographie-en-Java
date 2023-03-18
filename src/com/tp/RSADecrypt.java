package com.tp;

import javax.crypto.Cipher;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.util.Base64;

public class RSADecrypt {
    public static void main(String[] args) throws Exception {
        String encodedCryptedMsg = "EIkAqD4XBGcEsU8fasPG3/BAc50vvpOSXBUGSOYIvYgk8NPC46YD7phQAi4E6RDgt2ecl97Ve+oAHmGBaVt6TA==";
        byte[] decodedeMSG = Base64.getDecoder().decode(encodedCryptedMsg);
        String encodedPrivateKey = "MIIBVAIBADANBgkqhkiG9w0BAQEFAASCAT4wggE6AgEAAkEAtH5punvSlpuBRsbhu3ODfeF0ywFVyO2G3zY7o0g/HpcVkItWX9ivHN1+/Q0B2b/Q0YI0b8+hgLR56oaSUdPJtQIDAQABAkAbdaH7M4xZymW0EVzVSmEmXQ8KNXVKIMzkl5kiIcMskXkws6uFweIJXREzvC8jsYCDNTIAjjM325zt2QkBAmtRAiEAyLvKhca3twU7H51m+5Xb9jAc3tUKMpqqJivsBJaeFd0CIQDmMBKSz7R7RrVEqcBsH79wxt0/YDMc6hn4GJKL7s6huQIgBH8QXkbBPrxDQsYH1ILa1nzlaKhk/hUw0oIRW1j0WZECIQCg72NM+aL5vYnmo7hA4EF8m8z8DkouIQ5fAu8SnrghIQIgQUUuitcI++o4Fr90xUi5fqR1uAClB9FE+ajd4pu+iFY=";
        byte[] decodedPrivateKey = Base64.getDecoder().decode(encodedPrivateKey);
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        PrivateKey privateKey = keyFactory.generatePrivate(new PKCS8EncodedKeySpec(decodedPrivateKey));
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.DECRYPT_MODE, privateKey);
        byte[] decryptedMSG = cipher.doFinal(decodedeMSG);
        System.out.println(new String(decryptedMSG));

    }
}
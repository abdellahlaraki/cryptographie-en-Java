package com.tp;

import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

public class AESDecrypt {
    public static void main(String[] args) throws Exception {
        String encodedEncryptedMsg = "j0s0V8w0eUZaB97C+euIOrv5B06eLUX7CgKItoCQqxU=";
        byte[] decodedEncryptedMsg = Base64.getDecoder().decode(encodedEncryptedMsg);
        String secret = "takidayrlabasaht";
        SecretKey secretKey = new SecretKeySpec(secret.getBytes(), 0, secret.length(), "AES");
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.DECRYPT_MODE, secretKey);
        byte[] decryptedMsg = cipher.doFinal(decodedEncryptedMsg);
        System.out.println(new String(decryptedMsg));

    }
}
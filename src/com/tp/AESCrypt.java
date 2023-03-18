package com.tp;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

public class AESCrypt {

    public static void main(String[] args) throws Exception {
        String message="Message en claire";
        String secret="takidayrlabasaht";//128
        SecretKey secretKey=new SecretKeySpec(secret.getBytes(),0,secret.length(),"AES");
        byte[] encodedKey = secretKey.getEncoded();

        Cipher cipher= Cipher.getInstance("AES");
        cipher.init(cipher.ENCRYPT_MODE,secretKey);
        byte[] encryptedMsg =cipher.doFinal(message.getBytes());
        String encodedEncryptedMsg= Base64.getEncoder().encodeToString(encryptedMsg);
        System.out.println("message :  "+encodedEncryptedMsg);
    }
}
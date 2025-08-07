package com.anshumanprajapati.problem.urlShort.strategy;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Base62 implements Strategy{

    private  String BASE62_CHARS;
    private   int BASE;
    private  long counter;

    public Base62(){
        this.BASE62_CHARS = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        this.BASE = 62;
        this.counter = 1;
    }

    public String encode(String longUrl){
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hashBytes = digest.digest(longUrl.getBytes());


            long id = 0;
            for (int i = 0; i < Math.min(hashBytes.length, 5); i++) {
                id = (id << 8) | (hashBytes[i] & 0xFF);
            }

            StringBuilder sb = new StringBuilder();
            if (id == 0) {
                return String.valueOf(BASE62_CHARS.charAt(0));
            }
            while (id > 0) {
                sb.append(BASE62_CHARS.charAt((int) (id % BASE)));
                id /= BASE;
            }
            return sb.reverse().toString();

        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("SHA-256 algorithm not found", e);
        }
    }


}

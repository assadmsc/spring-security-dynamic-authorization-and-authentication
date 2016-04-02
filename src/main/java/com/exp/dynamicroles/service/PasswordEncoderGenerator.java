package com.exp.dynamicroles.service;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordEncoderGenerator {

	public static void main(String[] args) {

//		int i = 0;
//		while (i < 10) {
//			String password = "123456";
//			BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
//			String hashedPassword = passwordEncoder.encode(password);
//
//			System.out.println(hashedPassword);
//			i++;
//		}
		
		
		System.out.println(digest("1111"));

	}
	
    private static String digest(final String string) {
        if (string == null) {
            return null;
        }
        MessageDigest md = null;
        try {
            md = MessageDigest.getInstance("BCrypt");
        } catch (final NoSuchAlgorithmException e) {
            throw new IllegalStateException(e);
        }
        md.reset();
        try {
//            if (salt != null) {
//                md.update(salt.getBytes("UTF-8"));
//            }
            return toHex(md.digest(string.getBytes("UTF-8")));
        } catch (final UnsupportedEncodingException e) {
            // Never happens as UTF-8 is always supported
            return null;
        }
    }
    
    private static String toHex(final byte[] bytes) {
        final char[] hexDigits = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F' };
        final char[] chars = new char[bytes.length * 2];
        int j = 0;
        int k;
        for (final byte element : bytes) {
            k = element;
            chars[j++] = hexDigits[(k >>> 4) & 0x0F];
            chars[j++] = hexDigits[k & 0x0F];
        }
        return new String(chars);
    }    
    	
}
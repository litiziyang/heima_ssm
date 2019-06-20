package com.itheima.ssm.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class bb extends BCryptPasswordEncoder {

    public static void main(String[] args) {
        System.out.println(getpassword("123"));
    }

     private static String getpassword(String ss){
    BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
         String encode = bCryptPasswordEncoder.encode(ss);

         return encode;
}
}




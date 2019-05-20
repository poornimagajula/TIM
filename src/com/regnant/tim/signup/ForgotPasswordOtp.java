package com.regnant.tim.signup;

import java.util.Random;

public class ForgotPasswordOtp {

   static String OTP() 
    { 
       
        int length=6;
        String numbers = "0123456789"; 
  
        // Using random method 
        Random rndm_method = new Random(); 
  
        char[] otp = new char[length]; 
  
        for (int i = 0; i < length; i++) 
        { 
            // Use of charAt() method : to get character value 
            // Use of nextInt() as it is scanning the value as int 
            otp[i] = numbers.charAt(rndm_method.nextInt(numbers.length())); 
        } 
        String s= String.valueOf(otp);
        return s; 
    } 

} 
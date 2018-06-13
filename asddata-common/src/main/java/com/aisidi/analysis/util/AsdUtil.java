package com.aisidi.analysis.util;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.UUID;

public class AsdUtil {

	
	public static String getId() {
		return DateUtil.getCurrentDate() + getUuid32() ;
	}
	
	
	public static String getUuid32() { 
        try { 
            MessageDigest md = MessageDigest.getInstance("MD5"); 
            UUID uuid = UUID.randomUUID(); 
            String guidStr = uuid.toString(); 
            md.update(guidStr.getBytes(), 0, guidStr.length()); 
            return new BigInteger(1, md.digest()).toString(16); 
        } catch (NoSuchAlgorithmException e) { 
            return null; 
        } 
    }
}

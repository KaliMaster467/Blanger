/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Core;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 *
 * @author root
 */
public class Security {
    
    
    public static String md5(String pass) throws NoSuchAlgorithmException{
        String org = pass;
        MessageDigest md = MessageDigest.getInstance("MD5");
        md.update(org.getBytes());
        byte[] dig = md.digest();
        StringBuffer sb = new StringBuffer();
        for(byte b : dig)
            sb.append(String.format("%02x", b & 0xff));
        return sb.toString();
    }
}

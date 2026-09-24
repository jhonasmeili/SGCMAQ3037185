/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package framework.util;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 *
 * @author aluno
 */
public class Hash {
    private Hash(){}
    
    public static String stringToHash(String string, String algorithm) throws NoSuchAlgorithmException, UnsupportedEncodingException{
        
        String result = null;
        MessageDigest md = MessageDigest.getInstance(algorithm);
        result = new BigInteger( 1, md.digest( string.getBytes("UTF-8") ) ).toString(16);
        
        return result;
    }
}

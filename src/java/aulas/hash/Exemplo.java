package aulas.hash;

import java.math.BigInteger;
import java.security.MessageDigest;
import framework.util.Hash;

public class Exemplo {
    public static void main(String[] args) throws Exception {
        
        String algorithm;
        algorithm = "SHA-1";
//        algorithm = "SHA-256";
//        algorithm = "SHA-512";
//        algorithm = "MD5";
        
        String s1 = "1234";
        String s2 = "1233";
        
        MessageDigest md = MessageDigest.getInstance( algorithm );
        
        String h1 = Hash.stringToHash(s1, algorithm);
        String h2 = Hash.stringToHash(s2, algorithm);
        
        System.out.println( s1 + " | " + h1 + " | " + h1.length() );
        System.out.println( s2 + " | " + h2 + " | " + h2.length() );
        System.out.println( "h1.equals(h2) " + h1.equals(h2) );
        
        s2 = "IFSP";
        h2 = Hash.stringToHash(s2, algorithm);
        System.out.println( s2 + " | " + h2 + " | " + h2.length() );
        System.out.println( "h1.equals(h2) " + h1.equals(h2) );
        
        System.out.println("###");
        
    }
}
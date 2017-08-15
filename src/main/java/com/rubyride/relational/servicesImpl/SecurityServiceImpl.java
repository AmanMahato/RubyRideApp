package com.rubyride.relational.servicesImpl;

import com.rubyride.relational.services.SecurityService;
import org.apache.commons.codec.binary.StringUtils;
import org.springframework.stereotype.Service;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.security.Key;
import java.util.Random;
import org.apache.commons.codec.binary.Base64;

/**
 * @author Aman Mahato
 */
@Service
public class SecurityServiceImpl implements SecurityService {

    private String algorithm = "AES";
    //private final byte[] keyValue = "ADBSJHJS12547896".getBytes();

    @Override
    public String encryptData(final String data,Key key) throws Exception {
        //final Key key = this.generateKey();
        final Cipher c = Cipher.getInstance(algorithm);
        c.init(Cipher.ENCRYPT_MODE, key);
        final byte[] encValue = c.doFinal(data.getBytes());
        final String encryptedValue = org.apache.commons.codec.binary.Base64.encodeBase64String(encValue);
        return encryptedValue;
    }

    @Override
    public String deCryptData(final String data,Key key) throws Exception {
        //final Key key = this.generateKey();
        final Cipher c = Cipher.getInstance(algorithm);
        c.init(Cipher.DECRYPT_MODE, key);
        final byte[] decordedValue=org.apache.commons.codec.binary.Base64.decodeBase64(data);
        final byte[] decValue = c.doFinal(decordedValue);
        final String decryptedValue = new String(decValue);
        return decryptedValue;
    }

    @Override
    public Key generateKey(String val) throws Exception {
        Key key = new SecretKeySpec(val.getBytes(), algorithm);
        return key;
    }

    @Override
    public String generateRandomString(){
        String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < 16) { // length of the random string.
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            salt.append(SALTCHARS.charAt(index));
        }
        String saltStr = salt.toString();
        return saltStr;
    }


    /*public static void main(String[] args) {
        SecurityServiceImpl testo=new SecurityServiceImpl();
        final String s=testo.generateRandomString();
        System.out.println(s);
        Key k=null;
        try {
              k=testo.generateKey(s);
              System.out.println(k.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            String si=testo.encryptData("Aman Kumar AMnfaefjoa fMahato",k);
            System.out.println(si);
            String r=testo.deCryptData(si,k);
            System.out.println(r);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }*/
}

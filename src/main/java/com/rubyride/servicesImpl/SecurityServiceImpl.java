package com.rubyride.servicesImpl;

import com.rubyride.services.SecurityService;
import org.springframework.stereotype.Service;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.security.Key;

/**
 * @author Aman Mahato
 */
@Service
public class SecurityServiceImpl implements SecurityService {

    private String algorithm = "AES";
    private final byte[] keyValue = "ADBSJHJS12547896".getBytes();

    @Override
    public String encryptData(final String data) throws Exception {
        final Key key = this.generateKey();
        final Cipher c = Cipher.getInstance(algorithm);
        c.init(Cipher.ENCRYPT_MODE, key);
        final byte[] encValue = c.doFinal(data.getBytes());
        final String encryptedValue = org.apache.commons.codec.binary.Base64.encodeBase64String(encValue);
        return encryptedValue;
    }

    @Override
    public String deCryptData(final String data) throws Exception {
        final Key key = this.generateKey();
        final Cipher c = Cipher.getInstance(algorithm);
        c.init(Cipher.DECRYPT_MODE, key);
        final byte[] decordedValue=org.apache.commons.codec.binary.Base64.decodeBase64(data);
        final byte[] decValue = c.doFinal(decordedValue);
        final String decryptedValue = new String(decValue);
        return decryptedValue;
    }

    private Key generateKey() throws Exception {
        Key key = new SecretKeySpec(keyValue, algorithm);
        return key;
    }

    /*public static void main(String[] args) {
        SecurityServiceImpl testo=new SecurityServiceImpl();
        try {
            String s=testo.encryptData("Aman");
            System.out.println(s);
            String r=testo.deCryptData(s);
            System.out.println(r);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }*/
}

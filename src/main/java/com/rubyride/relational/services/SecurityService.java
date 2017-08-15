package com.rubyride.relational.services;

import java.security.Key;

/**
 * @author Aman Mahato
 */
public interface SecurityService {

    public String encryptData(String data,Key key) throws Exception;
    public String deCryptData(String data,Key key) throws Exception;
    public String generateRandomString();
    public Key generateKey(String val) throws Exception;
}

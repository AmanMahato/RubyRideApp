package com.rubyride.services;

/**
 * @author Aman Mahato
 */
public interface SecurityService {

    public String encryptData(String data) throws Exception;
    public String deCryptData(String data) throws Exception;
}

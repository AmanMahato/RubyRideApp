package com.rubyride.services;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * @author Aman Mahato
 */
public interface CsvService {

    public Map<String,String> getBirthOrderAndPresName();
    public Map<String,String> getBirthOrderAndDob();
    public Map<String,String> getBirthOrderAndDatestarted();
    public Map<String,String> getBirthOrderAndDateended();
    public List<Map<String, String>> parseCsv() throws IOException;

}

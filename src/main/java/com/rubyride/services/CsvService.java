package com.rubyride.services;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Aman Mahato
 */
public interface CsvService {

    public LinkedHashMap<String,String> getBirthOrderAndPresName();
    public LinkedHashMap<String,String> getBirthOrderAndDob();
    public LinkedHashMap<String,String> getBirthOrderAndDatestarted();
    public LinkedHashMap<String,String> getBirthOrderAndDateended();
    public List<Map<String, String>> parseCsv() throws IOException;
    public void operation();
}

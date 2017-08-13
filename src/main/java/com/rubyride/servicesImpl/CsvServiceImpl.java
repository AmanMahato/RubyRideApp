package com.rubyride.servicesImpl;

import com.opencsv.CSVReader;
import com.rubyride.services.CsvService;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.*;

/**
 * @author Aman Mahato
 */

@Service
public class CsvServiceImpl implements CsvService,Closeable {

    CSVReader csvReader;
    private LinkedHashMap<String,String> birthOrderAndPresName;
    private LinkedHashMap<String,String> birthOrderAndDob;
    private LinkedHashMap<String,String> birthOrderAndDatestarted;
    private LinkedHashMap<String,String> birthOrderAndDateended;

    public CsvServiceImpl() {
        this.operation();
    }

    @Override
    public Map<String, String> getBirthOrderAndPresName() {
        return birthOrderAndPresName;
    }

    @Override
    public Map<String, String> getBirthOrderAndDob() {
        return birthOrderAndDob;
    }

    @Override
    public Map<String, String> getBirthOrderAndDatestarted() {
        return birthOrderAndDatestarted;
    }

    @Override
    public Map<String, String> getBirthOrderAndDateended() {
        return birthOrderAndDateended;
    }

    @Override
    public List<Map<String, String>> parseCsv() throws IOException {
        csvReader=new CSVReader(new FileReader("./src/main/resources/PresidentDataMain.csv"));
            Iterator<String[]> valuesIterator = csvReader.iterator();

            String[] keys;
            if(valuesIterator.hasNext() == false) throw new IOException("Could not parse as a CSV file because the file was empty");
            else keys = valuesIterator.next();

            List<Map<String, String>> maps = new ArrayList<Map<String, String>>();
            valuesIterator.forEachRemaining((String[] item) -> {
                Map<String, String> map = new HashMap<String, String>();
                for(int i = 0; i < keys.length; i++) {
                    if(i >= item.length) {
                        map.put(keys[i], "");
                    } else {
                        map.put(keys[i], item[i]);
                    }
                }
                maps.add(map);
            });
            return maps;
        }

    private void operation() {
        CsvServiceImpl testObj=new CsvServiceImpl();
        List<Map<String,String>> result=null;
        try {
            result=testObj.parseCsv();
        } catch (IOException e) {
            e.printStackTrace();
        }
        for(Map<String,String> map:result){
            /*System.out.println(map.get("President"));
            System.out.println(map.get("Id"));
            System.out.println(map.get("Date Started Office"));
            System.out.println(map.get("Date Ended Office"));
            System.out.println(map.get("Date of birth"));*/
            birthOrderAndPresName.put(map.get("Id"),map.get("President"));
            birthOrderAndDob.put(map.get("Id"),map.get("Date of birth"));
            birthOrderAndDatestarted.put(map.get("Id"),map.get("Date Started Office"));
            birthOrderAndDateended.put(map.get("Id"),map.get("Date Ended Office"));
           /* for(Map.Entry<String,String> m:map.entrySet()){
                //System.out.println(m.getKey());
                //System.out.println(m.getValue());
                //System.out.println();
            }*/
        }
    }

    @Override
    public void close() throws IOException {
        csvReader.close();
    }
}

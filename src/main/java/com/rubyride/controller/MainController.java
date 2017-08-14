package com.rubyride.controller;

import com.rubyride.model.President;
import com.rubyride.services.CsvService;
import com.rubyride.services.PresidentNameService;
import com.rubyride.services.SecurityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Key;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author Aman Mahato
 */

@Controller
@RequestMapping("/")
public class MainController {

    LinkedHashMap<Key,String> secretKeyMap=new LinkedHashMap<>();

    @Autowired
    private CsvService csvService;

    @Autowired
    private SecurityService securityService;

    @Autowired
    private PresidentNameService presidentNameService;

    @RequestMapping("/")
    public String home(){
       return "test";
    }

    @RequestMapping("handlePresidentName")
    public String presidentNameIntoSql(){
        csvService.operation();
        Map map=csvService.getBirthOrderAndPresName();
        for(Map.Entry<String,String> m:(Set<Map.Entry>)map.entrySet()){
            String tempKeyString=null;
            Key tempKey=null;
            try {
                tempKeyString=securityService.generateRandomString();
                tempKey=securityService.generateKey(tempKeyString);
                while(secretKeyMap.containsKey(tempKey)){
                    tempKeyString=securityService.generateRandomString();
                    tempKey=securityService.generateKey(tempKeyString);
                }
                secretKeyMap.put(tempKey,m.getKey());//getkey gives the id. It maps the secretkey to id, used in decryption.
            } catch (Exception e) {
                e.printStackTrace();
            }
            President target=new President();
            target.setBirthOrder(Integer.valueOf(m.getKey()));
            try {
                target.setPresidentName(securityService.encryptData(m.getValue(),tempKey));
            } catch (Exception e) {
                e.printStackTrace();
            }
            presidentNameService.addPresidentName(target);
        }
        return "test";
    }
}

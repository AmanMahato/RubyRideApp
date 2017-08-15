package com.rubyride.controller;

//import com.rubyride.model.PresidencyRelatedDates;
import com.rubyride.relational.model.President;
import com.rubyride.relational.services.CsvService;
//import com.rubyride.services.PresidencyRelatedDatesService;
import com.rubyride.relational.services.PresidentNameService;
import com.rubyride.relational.services.SecurityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Key;
import java.util.*;

/**
 * @author Aman Mahato
 */

@Controller
@RequestMapping("/")
public class MainController {

    //locally stores all the secret key which later can be used for decryption
    LinkedHashMap<Key,String> secretKeyMap=new LinkedHashMap<>();

    @Autowired
    private CsvService csvService;

    @Autowired
    private SecurityService securityService;

    @Autowired
    private PresidentNameService presidentNameService;

    //@Autowired
    //private PresidencyRelatedDatesService presidencyRelatedDatesService;

    @RequestMapping("/")
    public String home(){
       return "test";
    }

    @RequestMapping("handlePresidentName")
    public String presidentNameIntoSql(){
        csvService.operation();
        Map map=csvService.getBirthOrderAndPresName();
        System.out.println(map.size());
        List<String> checkDuplicate=new ArrayList<>();
        for(Map.Entry<String,String> m:(Set<Map.Entry>)map.entrySet()){
            Key tempKey=null;
            try {
                String tempKeyString=securityService.generateRandomString();;
                tempKey=securityService.generateKey(tempKeyString);
                while(secretKeyMap.containsKey(tempKey)){//wrong with this loop
                    tempKeyString=securityService.generateRandomString();
                    tempKey=securityService.generateKey(tempKeyString);
                }
                secretKeyMap.put(tempKey,m.getKey());//getkey gives the id. It maps the secretkey to id, used in decryption.
            } catch (Exception e) {
                e.printStackTrace();
            }
            President target=new President();

            if(checkDuplicate.contains(m.getKey())){
                continue;
            }
            target.setBirthOrder(Integer.valueOf(m.getKey()));
            try {
                target.setPresidentName(securityService.encryptData(m.getValue(),tempKey));
            } catch (Exception e) {
                e.printStackTrace();
            }
            presidentNameService.addPresidentName(target);
            checkDuplicate.add(m.getKey());
        }
        return "test";
    }

    //put proper RequestMapping
    /*@RequestMapping("save")
    public String save(){
        //Get all dates from respective map
        csvService.operation();
        Map idAndDob=csvService.getBirthOrderAndDob();
        Map idAndDateStarted=csvService.getBirthOrderAndDatestarted();
        Map idAndDateEnded=csvService.getBirthOrderAndDateended();
        //create object of Presidency Related Dates
        int id=1;
        while(id<45){
            PresidencyRelatedDates presidencyRelatedDates=new PresidencyRelatedDates();
            presidencyRelatedDates.setDob((String)idAndDob.get(String.valueOf(id)));
            presidencyRelatedDates.setDateStarted((String)idAndDateStarted.get(String.valueOf(id)));
            presidencyRelatedDates.setDateEnded((String)idAndDateEnded.get(String.valueOf(id)));
            presidencyRelatedDatesService.savePresidencyRelatedDates(presidencyRelatedDates);
            id++;
        }

        return "test";
    }
*/


    /*public static void main(String[] args) {
        MainController testObj=new MainController();
        testObj.presidentNameIntoSql();

    }*/
}

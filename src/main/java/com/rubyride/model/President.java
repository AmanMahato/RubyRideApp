package com.rubyride.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @author Aman Mahato
 */

@Entity
public class President {

    @Id
    @Column(name = "birth_order",unique = true,nullable = false)
    public Integer birthOrder;

    @Column(name = "name")
    public String presidentName;

    @Column(name = "name_guid")
    public String presidentNameGuid;

    public String getPresidentNameGuid() {
        return presidentNameGuid;
    }

    public void setPresidentNameGuid(String presidentNameGuid) {
        this.presidentNameGuid = presidentNameGuid;
    }

    public Integer getBirthOrder() {
        return birthOrder;
    }

    public void setBirthOrder(Integer birthOrder) {
        this.birthOrder = birthOrder;
    }



    public String getPresidentName() {
        return presidentName;
    }

    public void setPresidentName(String presidentName) {
        this.presidentName = presidentName;
    }
}

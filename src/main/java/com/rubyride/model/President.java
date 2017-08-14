package com.rubyride.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Aman Mahato
 */

@Entity
@Table(name="PresidentInfo")
public class President {

    @Id
    @Column(name = "birth_order",unique = true,nullable = false)
    public Integer birthOrder;

    @Column(name = "name")
    public String presidentName;


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

package com.rubyride.relational.model;

import org.neo4j.ogm.classloader.Strategy;

import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;

/**
 * @author Aman Mahato
 */

@Entity
@Table(name="PresidentInfo")
public class President {

    @Id
    @Column(name = "birth_order",unique = true,nullable = false)
    //@GeneratedValue(strategy=IDENTITY)
    public Integer birthOrder;

    @Column(name = "name")
    public String presidentName;

    public President(){

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

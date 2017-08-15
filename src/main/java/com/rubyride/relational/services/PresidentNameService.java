package com.rubyride.relational.services;

import com.rubyride.relational.model.President;

import java.util.List;

/**
 * @author Aman Mahato
 */
public interface PresidentNameService {

    public void addPresidentName(President p);
    public President getByBirthOrder(Integer id);
    public List<President> getAllPresidentName();

}

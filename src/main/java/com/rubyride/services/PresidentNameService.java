package com.rubyride.services;

import com.rubyride.model.President;

import java.util.List;

/**
 * @author Aman Mahato
 */
public interface PresidentNameService {

    public void addPresidentName(President p);
    public President getByBirthOrder(Integer id);
    public List<President> getAllPresidentName();

}

package com.rubyride.dao;

import com.rubyride.model.President;

import java.util.List;

/**
 * @author Aman Mahato
 */
public interface PresidentNameDao {

    public void persist(President president);
    public President findByBirthOrder(Integer id);
    public List<President> findAll();

}

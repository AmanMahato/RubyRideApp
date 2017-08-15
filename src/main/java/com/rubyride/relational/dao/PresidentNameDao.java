package com.rubyride.relational.dao;

import com.rubyride.relational.model.President;

import java.util.List;

/**
 * @author Aman Mahato
 */
public interface PresidentNameDao {

    public void persist(President president);
    public President findByBirthOrder(Integer id);
    public List<President> findAll();

}

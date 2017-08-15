package com.rubyride.relational.servicesImpl;

import com.rubyride.relational.dao.PresidentNameDao;
import com.rubyride.relational.model.President;
import com.rubyride.relational.services.PresidentNameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Aman Mahato
 */

@Service
public class PresidentNameServiceImpl implements PresidentNameService {

    @Autowired
    private PresidentNameDao presidentNameDao;

    public void setPresidentNameDao(PresidentNameDao presidentNameDao){
        this.presidentNameDao=presidentNameDao;
    }

    @Override
    public void addPresidentName(President p) {
        this.presidentNameDao.persist(p);
    }

    @Override
    public President getByBirthOrder(Integer id) {
        return this.presidentNameDao.findByBirthOrder(id);
    }

    @Override
    public List<President> getAllPresidentName() {
        return this.presidentNameDao.findAll();
    }
}

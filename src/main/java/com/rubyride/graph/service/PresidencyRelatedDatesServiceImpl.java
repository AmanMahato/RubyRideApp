package com.rubyride.graph.service;

import com.rubyride.graph.model.PresidencyRelatedDates;
import com.rubyride.graph.repo.PresidencyRelatedDatesRepo;
import com.rubyride.graph.service.PresidencyRelatedDatesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PresidencyRelatedDatesServiceImpl implements PresidencyRelatedDatesService {

    @Autowired
    PresidencyRelatedDatesRepo presidencyRelatedDatesRepo;

    @Override
    @Transactional
    public void savePresidencyRelatedDates(PresidencyRelatedDates presidencyRelatedDates){
        presidencyRelatedDatesRepo.save(presidencyRelatedDates);
    }


}

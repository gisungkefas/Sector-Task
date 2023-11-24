package com.kefas.TaskBackend.service;

import com.kefas.TaskBackend.dto.DataDto;
import com.kefas.TaskBackend.entity.Data;
import com.kefas.TaskBackend.entity.Sectors;
import com.kefas.TaskBackend.repository.DataRepository;
import com.kefas.TaskBackend.repository.SectorsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DataService {

    @Autowired
    private DataRepository dataRepository;

    @Autowired
    private SectorsRepository sectorsRepository;

    public List<Sectors> getAllData() {
        return sectorsRepository.findAll();
    }

    public void saveData(DataDto data) {

        Data entity = new Data();
        entity.setName(data.getName());
        entity.setSectors(data.getSectors());
        entity.setAgreeTerms(data.isAgreeTerms());

        dataRepository.save(entity);
    }

}

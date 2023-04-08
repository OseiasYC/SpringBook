package com.ucsal.springlab.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ucsal.springlab.model.Lab;
import com.ucsal.springlab.repository.LabRepository;

@Service
public class LabService {

    @Autowired
    private LabRepository labRepository;

    public List<String> getLabs() {
        return labRepository.getLabs();
    }

    public void save(Lab lab) {
        labRepository.save(lab);
    }
}
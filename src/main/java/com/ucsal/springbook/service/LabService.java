package com.ucsal.springbook.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ucsal.springbook.model.Lab;
import com.ucsal.springbook.repository.LabRepository;

@Service
public class LabService {
    @Autowired
    private LabRepository labRepository;

    public List<String> getLabs() {
        return labRepository.getLabs();
    }

    public Lab getLab(String location) {
        location = location.replaceAll(".*?\\((.*?)\\).*?", "$1");
        System.out.println(location);
        return labRepository.getLab(location).get();
    }
}

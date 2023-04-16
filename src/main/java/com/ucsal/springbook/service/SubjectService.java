package com.ucsal.springbook.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ucsal.springbook.model.Subject;
import com.ucsal.springbook.repository.SubjectRepository;

@Service
public class SubjectService {

    @Autowired
    private SubjectRepository subjectRepository;

    public Subject getSubject(String subject) {
        return subjectRepository.getSubject(subject).get();
    }

    public List<String> getSubjectsByLogin(String username) {
        return subjectRepository.getSubjectsByLogin(username);
    }

}

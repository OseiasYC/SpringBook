package com.ucsal.springlab.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ucsal.springlab.models.Admin;
import com.ucsal.springlab.repositories.AdminRepository;

@Service
public class AdminService {

    @Autowired(required = false)
    private AdminRepository adminRepository;

    public void saveAdmin(Admin admin) {
        adminRepository.save(admin);
    }
    
}

package com.ucsal.springlab;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.ucsal.springlab.models.Admin;
import com.ucsal.springlab.services.AdminService;

@Component
public class DataInitializer implements CommandLineRunner {
    
    @Autowired
    private AdminService adminService;

    @Override
    public void run(String... args) throws Exception {
        // Admin admin = new Admin();
        // admin.setName("Osvaldo");
        // admin.setLogin("admin");
        // admin.setPassword("admin");
        // adminService.saveAdmin(admin);
    }
}

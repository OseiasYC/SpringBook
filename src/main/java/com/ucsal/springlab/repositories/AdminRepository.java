package com.ucsal.springlab.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ucsal.springlab.models.Admin;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Integer> {
    
}

package com.ucsal.springlab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ucsal.springlab.model.Lab;

@Repository
public interface LabRepository extends JpaRepository<Lab, Long>{
    
}

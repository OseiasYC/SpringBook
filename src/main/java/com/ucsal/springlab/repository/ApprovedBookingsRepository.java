package com.ucsal.springlab.repository;

import org.springframework.stereotype.Repository;

import com.ucsal.springlab.model.ApprovedBookings;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface ApprovedBookingsRepository extends JpaRepository<ApprovedBookings, Long>{
    
    
}

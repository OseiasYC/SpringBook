package com.ucsal.springlab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ucsal.springlab.model.Booking;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long>{
    
    void deleteById(Long id);
}

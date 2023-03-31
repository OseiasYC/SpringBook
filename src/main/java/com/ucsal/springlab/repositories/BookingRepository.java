package com.ucsal.springlab.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ucsal.springlab.models.Booking;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {
    
}

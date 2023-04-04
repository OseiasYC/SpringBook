package com.ucsal.springlab.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ucsal.springlab.model.Booking;

@Repository
public interface BookingRepository extends CrudRepository<Booking, Long>{
    
}

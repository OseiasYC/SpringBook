package com.ucsal.springlab.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ucsal.springlab.models.Booking;

@Repository
public interface BookingRepository extends CrudRepository<Booking, Integer> {

}

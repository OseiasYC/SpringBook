package com.ucsal.springlab.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ucsal.springlab.model.Booking;
import com.ucsal.springlab.repository.ApprovedBookingsRepository;

@Service
public class ApprovedBookingsService {

    @Autowired
    ApprovedBookingsRepository approvedBookingsRepository;

    public void save(Optional<Booking> booking) {
        approvedBookingsRepository.save(booking.get());
    }
    
}

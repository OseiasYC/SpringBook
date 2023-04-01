package com.ucsal.springlab.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ucsal.springlab.models.Booking;
import com.ucsal.springlab.repositories.BookingRepository;

@Service
public class BookingService {

    @Autowired(required = false)
    private BookingRepository bookingRepository;

    public void save(Booking booking) {
        bookingRepository.save(booking);
    }
}
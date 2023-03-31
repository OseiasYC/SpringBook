package com.ucsal.springlab;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.ucsal.springlab.models.Booking;
import com.ucsal.springlab.services.BookingService;

@Component
public class DataInitializer implements CommandLineRunner {
    
    @Autowired
    private BookingService bookingService;

    @Override
    public void run(String[] args) throws Exception {
        Booking booking = new Booking();
        booking.setSubject("Arquitetura de Software");

        bookingService.save(booking);
    }
}

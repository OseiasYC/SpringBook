package com.ucsal.springlab;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.ucsal.springlab.services.BookingService;
@Component
public class DataInitializer implements CommandLineRunner{
	
	private BookingService bookingService;
	
	public void run(String args[]) throws Exception {
		
		 // Booking booking = new Booking();
        // booking.setSubject("Arquitetura de Software");

        // bookingService.save(booking);
	}
}

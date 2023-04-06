package com.ucsal.springlab.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ucsal.springlab.model.Booking;
import com.ucsal.springlab.repository.BookingRepository;

@Service
public class BookingService {
    
    @Autowired
    private BookingRepository bookingRepository;

    public void save(String professor, String subject, String lab, String date, String timeInit, String timeFinal) {

    Booking booking = new Booking();
    LocalDateTime initialTime = LocalDateTime.parse(date + "T" + timeInit + ":00");
    LocalDateTime finalTime = LocalDateTime.parse(date + "T" + timeFinal + ":00");

    booking.setProfessor(professor);
    booking.setSubject(subject);
    booking.setLab(lab);
    booking.setTimeInit(initialTime);
    booking.setTimeFinal(finalTime);

    bookingRepository.save(booking);
    }
}

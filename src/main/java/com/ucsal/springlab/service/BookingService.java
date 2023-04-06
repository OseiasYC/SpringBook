package com.ucsal.springlab.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ucsal.springlab.model.Booking;
import com.ucsal.springlab.repository.ApprovedBookingsRepository;
import com.ucsal.springlab.repository.BookingRepository;

@Service
public class BookingService {
    
    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private ApprovedBookingsRepository approvedBookingsRepository;

    public void save(String professor, String subject, String lab, String date, LocalDateTime timeRequest, String timeInit, String timeFinal) {
    Booking booking = new Booking();
    LocalDateTime initialTime = LocalDateTime.parse(date + "T" + timeInit + ":00");
    LocalDateTime finalTime = LocalDateTime.parse(date + "T" + timeFinal + ":00");

    booking.setProfessor(professor);
    booking.setSubject(subject);
    booking.setLab(lab);
    booking.setTimeRequest(timeRequest);
    booking.setTimeInit(initialTime);
    booking.setTimeFinal(finalTime);

    bookingRepository.save(booking);
    }

    public List<Booking> findAll(){
        return bookingRepository.findAll();
    }

    public void delete(Long id) {
        bookingRepository.deleteById(id);
    }

    public void saveToApprove(Long id) {
        
    }
}

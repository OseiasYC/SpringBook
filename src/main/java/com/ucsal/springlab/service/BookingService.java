package com.ucsal.springlab.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.ucsal.springlab.model.Booking;
import com.ucsal.springlab.repository.BookingRepository;

@Service
@EnableScheduling
public class BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private ApprovedBookingsService approvedBookingsService;

    public void save(String professor, String subject, String lab, String date, String timeInit, String timeFinal) {
        Booking booking = new Booking();
        LocalDateTime initialTime = LocalDateTime.parse(date + "T" + timeInit + ":00");
        LocalDateTime finalTime = LocalDateTime.parse(date + "T" + timeFinal + ":00");

        booking.setProfessor(professor);
        booking.setSubject(subject);
        booking.setLab(lab);
        booking.setTimeRequest(LocalDateTime.now());
        booking.setTimeInit(initialTime);
        booking.setTimeFinal(finalTime);

        bookingRepository.save(booking);
    }

    public List<Booking> findAll() {
        return bookingRepository.findAll();
    }

    public void delete(Long id) {
        bookingRepository.deleteById(id);
    }

    public Optional<Booking> findById(Long id) {
        return bookingRepository.findById(id);
    }

    public void saveApproved(Optional<Booking> booking) {
        approvedBookingsService.save(booking);
    }

    @Async
    @Scheduled(fixedDelay = 60000)
    void verify() {
        bookingRepository.deleteByTimeFinalBefore(LocalDateTime.now());
    }
}
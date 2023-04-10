package com.ucsal.springbook.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.ucsal.springbook.model.Booking;
import com.ucsal.springbook.repository.BookingRepository;

@Service
@EnableScheduling
public class BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private ApprovedBookingsService approvedBookingsService;

    @Autowired 
    private LogService logService;

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

        logService.insertedPending(booking);
        bookingRepository.save(booking);
    }

    public List<Booking> findAll() {
        return bookingRepository.findAll();
    }

    public void delete(Long id) {
        logService.deletedPending(findById(id).get());
        bookingRepository.deleteById(id);
    }

    public Optional<Booking> findById(Long id) {
        return bookingRepository.findById(id);
    }

    public void saveApproved(Optional<Booking> booking) {
        logService.insertedApproved(booking.get());
        approvedBookingsService.save(booking);
    }

    public boolean isBusy(Optional<Booking> booking){
        int count = approvedBookingsService.isBusy(booking.get().getLab(), booking.get().getTimeInit(),
                booking.get().getTimeFinal());
                
        if (count > 0) {
            return true;
        } else {
            return false;
        }
    }

    @Async
    @Scheduled(fixedDelay = 60000)
    void verify() {
        bookingRepository.deleteByTimeFinalBefore(LocalDateTime.now());
    }
}
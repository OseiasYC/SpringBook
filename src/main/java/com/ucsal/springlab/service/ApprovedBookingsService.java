package com.ucsal.springlab.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.ucsal.springlab.model.ApprovedBookings;
import com.ucsal.springlab.model.Booking;
import com.ucsal.springlab.repository.ApprovedBookingsRepository;

@Service
@EnableScheduling
public class ApprovedBookingsService {

    @Autowired
    ApprovedBookingsRepository approvedBookingsRepository;

    public void save(Optional<Booking> booking) {
        approvedBookingsRepository.save(booking.get());
    }

    public List<ApprovedBookings> findAll() {
        return approvedBookingsRepository.findAll();
    }

    @Async
    @Scheduled(fixedDelay = 60000)
    void verify() {
        approvedBookingsRepository.deleteByTimeFinalBefore(LocalDateTime.now());
    }

    public void delete(Long id) {
        approvedBookingsRepository.deleteById(id);
    }
}
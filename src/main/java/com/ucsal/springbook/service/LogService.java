package com.ucsal.springbook.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import com.ucsal.springbook.model.Booking;

@Service
public class LogService {
    private static final Logger log = LogManager.getLogger(LogService.class);

    public void deletedPending(Booking booking) {
        log.info("Pending removed: {}", booking.toString());
    }

    public void insertedPending(Booking booking) {
        log.info("Pending inserted: {}", booking.toString());
    }

    public void deletedApproved(Booking booking) {
        log.info("Approved removed: {}", booking.toString());
    }

    public void insertedApproved(Booking booking) {
        log.info("Approved inserted: {}", booking.toString());
    }
}
package com.ucsal.springbook.repository;

import java.time.LocalDateTime;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ucsal.springbook.model.Booking;

import jakarta.transaction.Transactional;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {

    @Transactional
    @Modifying
    void deleteById(Long id);

    @Transactional
    @Modifying
    @Query(value = "DELETE FROM books ab WHERE ab.time_final < ?1", nativeQuery = true)
    void deleteByTimeFinalBefore(LocalDateTime now);
}
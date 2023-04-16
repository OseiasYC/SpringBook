package com.ucsal.springbook.repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ucsal.springbook.model.Booking;

import jakarta.transaction.Transactional;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long>{
    
    @Query(value = "SELECT * FROM booking WHERE approved = false", nativeQuery = true)
    List<Booking> findPending();

    @Query(value = "SELECT * FROM booking WHERE approved = true", nativeQuery = true)
    List<Booking> findApproved();

    @Query(value = "SELECT COUNT(*) FROM booking b WHERE b.lab_id = ?1 AND ((b.time_init <= ?2 AND b.time_final >= ?2) OR (b.time_init <= ?3 AND b.time_final >= ?3)) AND b.approved = true", nativeQuery = true)
    int isBusy(long lab, LocalDateTime timeInit, LocalDateTime timeFinal);

    @Override
    Optional<Booking> findById(Long id);

    @Transactional
    @Modifying
    @Query(value = "UPDATE booking SET approved = true WHERE id = ?1", nativeQuery = true)
    void approveBooking(long id);

    @Transactional
    @Modifying
    @Query(value = "DELETE FROM booking WHERE time_final < ?1", nativeQuery = true)
    void deleteByTimeFinalBefore(LocalDateTime now);

}

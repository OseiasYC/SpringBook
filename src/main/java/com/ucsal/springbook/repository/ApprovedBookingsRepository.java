package com.ucsal.springbook.repository;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ucsal.springbook.model.ApprovedBookings;
import com.ucsal.springbook.model.Booking;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

@Repository
public interface ApprovedBookingsRepository extends JpaRepository<ApprovedBookings, Long> {

        @Transactional
        @Modifying
        @Query(value = "INSERT INTO approved_books (id, lab, professor, subject, time_final, time_init, time_request) "
        + "VALUES (:#{#book.id}, :#{#book.lab}, :#{#book.professor}, :#{#book.subject}, :#{#book.timeFinal}, :#{#book.timeInit}, :#{#book.timeRequest})", nativeQuery = true)
        void save(@Param("book") Booking book);

        @Query(value = "SELECT * FROM approved_books ORDER BY time_init", nativeQuery = true)
        List<ApprovedBookings> findAll();

        @Transactional
        @Modifying
        @Query(value = "DELETE FROM approved_books ab WHERE ab.time_final < ?1", nativeQuery = true)
        void deleteByTimeFinalBefore(LocalDateTime now);

        @Query(value = "SELECT COUNT(*) FROM approved_books ab WHERE ab.lab = ?1 AND ((ab.time_init <= ?2 AND ab.time_final >= ?2) OR (ab.time_init <= ?3 AND ab.time_final >= ?3))", nativeQuery = true)
        int isBusy(String lab, LocalDateTime timeInit, LocalDateTime timeFinal);

        @Transactional
        @Modifying
        void deleteById(Long id);
}
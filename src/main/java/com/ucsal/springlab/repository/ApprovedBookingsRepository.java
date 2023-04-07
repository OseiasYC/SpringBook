package com.ucsal.springlab.repository;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ucsal.springlab.model.ApprovedBookings;
import com.ucsal.springlab.model.Booking;

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
}

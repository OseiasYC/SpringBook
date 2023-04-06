package com.ucsal.springlab.repository;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ucsal.springlab.model.ApprovedBookings;

import java.time.LocalDateTime;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

@Repository
public interface ApprovedBookingsRepository extends JpaRepository<ApprovedBookings, Long>{

    @Transactional
    @Modifying
    @Query(value="INSERT INTO approved_books (id, lab, professor, subject, time_final, time_init, time_request) " +
            "VALUES (?1, ?2, ?3, ?4, ?5, ?6, ?7)", nativeQuery = true)
    void save(Long id, String lab, String professor, String subject, LocalDateTime time_final, LocalDateTime time_init,
            LocalDateTime time_request);
}

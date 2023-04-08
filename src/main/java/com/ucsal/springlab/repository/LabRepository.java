package com.ucsal.springlab.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ucsal.springlab.model.Lab;

@Repository
public interface LabRepository extends JpaRepository<Lab, Long> {

    @Query("SELECT CONCAT(lami, ' (', location, ')') AS lami_location FROM Lab WHERE status != 'false'")
    List<String> getLabs();
}
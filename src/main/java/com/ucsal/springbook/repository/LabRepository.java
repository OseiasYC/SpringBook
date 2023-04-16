package com.ucsal.springbook.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ucsal.springbook.model.Lab;

@Repository
public interface LabRepository extends JpaRepository<Lab, Long>{
    
    @Query("SELECT CONCAT(lami, ' (', location, ')') AS lami_location FROM Lab WHERE status != 'false'")
    List<String> getLabs();
    
    @Query(value = "SELECT * FROM lab WHERE location = ?1", nativeQuery = true)
    Optional<Lab> getLab(String location);
}

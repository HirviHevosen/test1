package com.example.application.data;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface FormSubmissionRepository extends JpaRepository<FormSubmission, Long> {

    @Query("SELECT c FROM Contact c JOIN FETCH c.company")
    List<FormSubmission> findAllWithCompany();
}

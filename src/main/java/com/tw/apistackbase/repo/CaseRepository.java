package com.tw.apistackbase.repo;

import com.tw.apistackbase.Entity.Case;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CaseRepository extends JpaRepository<Case, String> {

    List<Case> findAllByOrderByTimeDesc();
}

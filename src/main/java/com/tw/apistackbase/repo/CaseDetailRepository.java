package com.tw.apistackbase.repo;

import com.tw.apistackbase.Entity.CaseDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CaseDetailRepository extends JpaRepository<CaseDetail, String> {
}

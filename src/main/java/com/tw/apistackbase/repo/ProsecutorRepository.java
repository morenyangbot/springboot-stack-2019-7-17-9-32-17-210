package com.tw.apistackbase.repo;

import com.tw.apistackbase.Entity.Prosecutor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProsecutorRepository extends JpaRepository<Prosecutor, String> {
}

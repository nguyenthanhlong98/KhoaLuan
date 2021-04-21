package com.example.demo.repository;

import com.example.demo.enity.PhieuDichVu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PhieuDichVuRepository extends JpaRepository<PhieuDichVu,Long> {
}

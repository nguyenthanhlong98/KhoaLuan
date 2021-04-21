package com.example.demo.repository;

import com.example.demo.enity.TaiKhoan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaiKhoantRepository extends JpaRepository<TaiKhoan,String> {
}

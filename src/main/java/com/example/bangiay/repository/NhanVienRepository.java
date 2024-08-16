package com.example.bangiay.repository;

import com.example.bangiay.entity.NhanVien;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface NhanVienRepository extends JpaRepository<NhanVien,UUID> {
    NhanVien findByEmail(String email);
    Boolean existsByEmail(String email);
}

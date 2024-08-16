package com.example.bangiay.repository;

import com.example.bangiay.entity.KhachHang;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface KhachHangRepository extends JpaRepository<KhachHang, UUID> {
    KhachHang findByEmail(String email);
    Boolean existsByEmail(String email);
}

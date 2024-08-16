package com.example.bangiay.repository;

import com.example.bangiay.entity.HangKhachHang;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface HangKhachHangRepository extends JpaRepository<HangKhachHang, UUID> {
}

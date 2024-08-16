package com.example.bangiay.repository;

import com.example.bangiay.entity.HoaDonChiTiet;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface HoaDonChiTietRepository extends JpaRepository<HoaDonChiTiet, UUID> {
}

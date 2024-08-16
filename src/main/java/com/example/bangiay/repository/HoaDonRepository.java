package com.example.bangiay.repository;

import com.example.bangiay.entity.HoaDon;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface HoaDonRepository extends JpaRepository<HoaDon, UUID> {
    // Tìm tất cả hóa đơn dựa trên ID của khách hàng
    List<HoaDon> findByKhachHangId(UUID khachHangId);
}

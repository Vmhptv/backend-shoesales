package com.example.bangiay.repository;

import com.example.bangiay.entity.DiaChi;
import com.example.bangiay.entity.HoaDon;
import com.example.bangiay.entity.KhachHang;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

public interface DiaChiRepository extends JpaRepository<DiaChi, UUID> {
    // Tìm tất cả Địa Chỉ dựa trên ID của khách hàng
    @Query("SELECT d FROM DiaChi d WHERE d.khachHang.id = :idKhachHang")
    List<DiaChi> findByIdKhachHang(@Param("idKhachHang") UUID idKhachHang);
}

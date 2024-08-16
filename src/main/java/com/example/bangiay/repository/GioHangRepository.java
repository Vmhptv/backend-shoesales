package com.example.bangiay.repository;

import com.example.bangiay.entity.DiaChi;
import com.example.bangiay.entity.GioHang;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface GioHangRepository extends JpaRepository<GioHang, UUID> {
    @Query("SELECT d FROM GioHang d WHERE d.khachHang.id = :khachHangId")
    GioHang findGioHangByKhachHangId(@Param("khachHangId") UUID khachHangId);
}

package com.example.bangiay.repository;


import com.example.bangiay.entity.DiaChi;
import com.example.bangiay.entity.GioHang;
import com.example.bangiay.entity.GioHangChiTiet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface GioHangChiTietRepository extends JpaRepository<GioHangChiTiet, UUID> {
    @Query("SELECT d FROM GioHangChiTiet d WHERE d.gioHang.id = :gioHangId")
    List<GioHangChiTiet> findByGioHangId(@Param("gioHangId") UUID gioHangId);
}

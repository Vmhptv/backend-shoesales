package com.example.bangiay.repository;

import com.example.bangiay.entity.ChucVu;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ChucVuRepository extends JpaRepository<ChucVu, UUID> {
    ChucVu findByMa(String ten);
}

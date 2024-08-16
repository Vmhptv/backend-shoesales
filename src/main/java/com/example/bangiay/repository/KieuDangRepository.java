package com.example.bangiay.repository;

import com.example.bangiay.entity.KieuDang;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface KieuDangRepository extends JpaRepository<KieuDang, UUID> {
}

package com.example.bangiay.repository;

import com.example.bangiay.entity.ThuongHieu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ThuongHieuRepository extends JpaRepository<ThuongHieu, UUID> {
}

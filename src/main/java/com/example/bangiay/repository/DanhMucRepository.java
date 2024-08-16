package com.example.bangiay.repository;

import com.example.bangiay.entity.DanhMuc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface DanhMucRepository extends JpaRepository<DanhMuc, UUID> {
}

package com.example.bangiay.repository;

import com.example.bangiay.entity.MauSac;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface MauSacRepository extends JpaRepository<MauSac, UUID> {
}

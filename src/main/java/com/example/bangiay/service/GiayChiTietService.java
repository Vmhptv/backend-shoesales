package com.example.bangiay.service;

import com.example.bangiay.entity.GiayChiTiet;

import java.util.List;
import java.util.UUID;

public interface GiayChiTietService {
    List<GiayChiTiet> getAll();
    public GiayChiTiet add(GiayChiTiet giayChiTiet);
    GiayChiTiet update(UUID id, GiayChiTiet giayChiTiet);
    GiayChiTiet deleteById(UUID id);
    public GiayChiTiet details(UUID id);
    public void updateStockQuantity(UUID id, Integer quantity, boolean isAdding);
}

package com.example.bangiay.service;

import com.example.bangiay.entity.HoaDonChiTiet;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface HoaDonChiTietService {
    public List<HoaDonChiTiet> getall();
    public HoaDonChiTiet add(HoaDonChiTiet hoaDonChiTiet);
    public HoaDonChiTiet update(UUID id,HoaDonChiTiet updateOderDetails );
    public boolean delete(UUID id);
    public Optional<HoaDonChiTiet> details(UUID id);
    public void adjustStockQuantity(HoaDonChiTiet hoaDonChiTiet, boolean isReturningStock);
}

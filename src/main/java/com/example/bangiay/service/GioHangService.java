package com.example.bangiay.service;

import com.example.bangiay.entity.GioHang;

import java.util.List;
import java.util.UUID;

public interface GioHangService {
    public List<GioHang> getall();
    public  GioHang add(GioHang gioHang);
    GioHang update(GioHang gioHang,UUID id);
    GioHang deleteById(UUID id);
    public GioHang details(UUID id);
}

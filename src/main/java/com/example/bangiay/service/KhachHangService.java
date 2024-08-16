package com.example.bangiay.service;

import com.example.bangiay.entity.KhachHang;


import java.util.List;
import java.util.UUID;

public interface KhachHangService {
    List<KhachHang> getAll();
    public KhachHang add(KhachHang khachHang);
    KhachHang update(UUID id,KhachHang khachHang);
    KhachHang deleteById(UUID id);
    public KhachHang details(UUID id);
}

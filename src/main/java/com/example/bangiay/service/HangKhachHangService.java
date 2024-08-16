package com.example.bangiay.service;

import com.example.bangiay.entity.HangKhachHang;


import java.util.List;
import java.util.UUID;

public interface HangKhachHangService {
    List<HangKhachHang> getAll();
    public HangKhachHang add(HangKhachHang hangKhachHang);
    HangKhachHang update(UUID id, HangKhachHang hangKhachHang);
    HangKhachHang deleteById(UUID id);
    public HangKhachHang details(UUID id);
}

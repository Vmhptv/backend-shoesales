package com.example.bangiay.service;

import com.example.bangiay.entity.GioHangChiTiet;

import java.util.List;
import java.util.UUID;

public interface GioHangChiTietService {
    List<GioHangChiTiet> getAll();
    public GioHangChiTiet add(GioHangChiTiet gioHangChiTiet);
    GioHangChiTiet update(UUID id, GioHangChiTiet gioHangChiTiet);
    GioHangChiTiet deleteById(UUID id);
    public GioHangChiTiet details(UUID id);
    List<GioHangChiTiet> getByKhachHangId(UUID khachHangId);
}

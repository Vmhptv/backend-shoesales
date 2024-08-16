package com.example.bangiay.service;

import com.example.bangiay.entity.ChuongTrinhGiamGiaChiTietSanPham;

import java.util.List;
import java.util.UUID;

public interface ChuongTrinhGiamGiaSanPhamChiTietService {
    List<ChuongTrinhGiamGiaChiTietSanPham> getAll();
    public ChuongTrinhGiamGiaChiTietSanPham add(ChuongTrinhGiamGiaChiTietSanPham chuongTrinhGiamGiaChiTietSanPham);
    ChuongTrinhGiamGiaChiTietSanPham update(UUID id, ChuongTrinhGiamGiaChiTietSanPham chuongTrinhGiamGiaChiTietSanPham);
    ChuongTrinhGiamGiaChiTietSanPham deleteById(UUID id);
    public ChuongTrinhGiamGiaChiTietSanPham details(UUID id);
}

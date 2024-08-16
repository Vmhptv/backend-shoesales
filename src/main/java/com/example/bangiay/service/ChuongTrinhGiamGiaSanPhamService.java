package com.example.bangiay.service;

import com.example.bangiay.entity.ChuongTrinhGiamGiaSanPham;


import java.util.List;
import java.util.UUID;

public interface ChuongTrinhGiamGiaSanPhamService {
    List<ChuongTrinhGiamGiaSanPham> getAll();
    public ChuongTrinhGiamGiaSanPham add(ChuongTrinhGiamGiaSanPham chuongTrinhGiamGiaSanPham);
    ChuongTrinhGiamGiaSanPham update(UUID id, ChuongTrinhGiamGiaSanPham chuongTrinhGiamGiaSanPham);
    ChuongTrinhGiamGiaSanPham deleteById(UUID id);
    public ChuongTrinhGiamGiaSanPham details(UUID id);
}

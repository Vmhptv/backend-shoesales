package com.example.bangiay.service;

import com.example.bangiay.entity.NhanVien;


import java.util.List;
import java.util.UUID;

public interface NhanVienService {
    List<NhanVien>getAll();
    public NhanVien add(NhanVien nhanVien);
    NhanVien update(UUID id, NhanVien nhanVien);
    NhanVien deleteById(UUID id);
    public NhanVien details(UUID id);
}

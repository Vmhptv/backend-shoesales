package com.example.bangiay.service;

import com.example.bangiay.entity.DiaChi;
import com.example.bangiay.entity.KhachHang;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface DiaChiService {
    public List<DiaChi> getAll();
    public Optional<DiaChi> getDiaChiById(UUID id);
    public List<DiaChi> getDiaChiByIdKhachHang(UUID idKhachHang);
    public DiaChi createDiaChi(DiaChi diaChi);
    public DiaChi updateDiaChi(UUID id, DiaChi diaChi);
    public boolean deleteDiaChi(UUID id);
}

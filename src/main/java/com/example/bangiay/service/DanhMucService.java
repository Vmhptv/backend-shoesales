package com.example.bangiay.service;

import com.example.bangiay.entity.DanhMuc;

import java.util.List;
import java.util.UUID;

public interface DanhMucService {
    List<DanhMuc> getAll();
    public DanhMuc add(DanhMuc danhMuc);
    DanhMuc update(UUID id, DanhMuc danhMuc);
    DanhMuc deleteById(UUID id);
    public DanhMuc details(UUID id);
}

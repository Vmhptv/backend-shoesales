package com.example.bangiay.service;

import com.example.bangiay.entity.ChucVu;

import java.util.List;
import java.util.UUID;

public interface ChucVuService {
    List<ChucVu> getAll();
    public ChucVu add(ChucVu chucVu);
    ChucVu update(UUID id, ChucVu chucVu);
    ChucVu deleteById(UUID id);
    public ChucVu details(UUID id);
}

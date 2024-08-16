package com.example.bangiay.service;

import com.example.bangiay.entity.KieuDang;

import java.util.List;
import java.util.UUID;

public interface KieuDangService {
    List<KieuDang> getAll();
    public KieuDang add(KieuDang kieuDang);
    KieuDang update(UUID id, KieuDang kieuDang);
    KieuDang deleteById(UUID id);
    public KieuDang details(UUID id);
}

package com.example.bangiay.service;

import com.example.bangiay.entity.ThuongHieu;

import java.util.List;
import java.util.UUID;

public interface ThuongHieuService {
    List<ThuongHieu> getAll();
    public ThuongHieu add(ThuongHieu thuongHieu);
    ThuongHieu update(UUID id, ThuongHieu thuongHieu);
    ThuongHieu deleteById(UUID id);
    public ThuongHieu details(UUID id);
}

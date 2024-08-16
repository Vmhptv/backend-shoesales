package com.example.bangiay.service;

import com.example.bangiay.entity.MauSac;

import java.util.List;
import java.util.UUID;

public interface MauSacService {
    List<MauSac> getAll();
    public MauSac add(MauSac mauSac);
    MauSac update(UUID id, MauSac mauSac);
    MauSac deleteById(UUID id);
    public MauSac details(UUID id);
}

package com.example.bangiay.service;

import com.example.bangiay.entity.Giay;

import java.util.List;
import java.util.UUID;

public interface GiayService {
    List<Giay> getAll();
    public Giay add(Giay giay);
    Giay update(UUID id, Giay giay);
    Giay deleteById(UUID id);
    public Giay details(UUID id);
}

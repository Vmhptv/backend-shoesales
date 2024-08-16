package com.example.bangiay.service;

import com.example.bangiay.entity.DeGiay;

import java.util.List;
import java.util.UUID;

public interface DeGiayService {
    List<DeGiay> getAll();
    public DeGiay add(DeGiay deGiay);
    DeGiay update(UUID id, DeGiay deGiay);
    DeGiay deleteById(UUID id);
    public DeGiay details(UUID id);
}

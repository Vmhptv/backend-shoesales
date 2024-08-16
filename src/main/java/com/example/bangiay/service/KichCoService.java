package com.example.bangiay.service;

import com.example.bangiay.entity.KichCo;

import java.util.List;
import java.util.UUID;

public interface KichCoService {
    public List<KichCo> getall();
    public KichCo add(KichCo kichCo);
    KichCo update(KichCo kichCo, UUID id);
    KichCo deleteById(UUID id);
    public KichCo details(UUID id);
}

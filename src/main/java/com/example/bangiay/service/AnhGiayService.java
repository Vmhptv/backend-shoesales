package com.example.bangiay.service;

import com.example.bangiay.entity.AnhGiay;

import java.util.List;
import java.util.UUID;

public interface AnhGiayService {
    List<AnhGiay> getAll();
    public AnhGiay add(AnhGiay anhGiay);
    AnhGiay update(UUID id, AnhGiay anhGiay);
    AnhGiay deleteById(UUID id);
    public AnhGiay details(UUID id);

}

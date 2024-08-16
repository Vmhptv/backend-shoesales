package com.example.bangiay.service;

import com.example.bangiay.entity.XuatXu;

import java.util.List;
import java.util.UUID;

public interface XuatXuService {
    List<XuatXu> getAll();
    public XuatXu add(XuatXu xuatXu);
    XuatXu update(UUID id, XuatXu xuatXu);
    XuatXu deleteById(UUID id);
    public XuatXu details(UUID id);
}

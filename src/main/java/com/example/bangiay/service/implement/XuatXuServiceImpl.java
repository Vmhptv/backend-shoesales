package com.example.bangiay.service.implement;

import com.example.bangiay.entity.XuatXu;
import com.example.bangiay.repository.XuatXuRepository;
import com.example.bangiay.service.XuatXuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class XuatXuServiceImpl implements XuatXuService {

    @Autowired
    private XuatXuRepository xuatXuRepository;

    @Override
    public List<XuatXu> getAll() {
        return xuatXuRepository.findAll();
    }

    @Override
    public XuatXu add(XuatXu xuatXu) {
        return xuatXuRepository.save(xuatXu);
    }

    @Override
    public XuatXu update(UUID id, XuatXu cl) {
        Optional<XuatXu> optional = xuatXuRepository.findById(id);
        return optional.map(o -> {
            o.setMa(cl.getMa());
            o.setTen(cl.getTen());
            o.setTrangThai(cl.getTrangThai());
            return xuatXuRepository.save(o);
        }).orElse(null);
    }

    @Override
    public XuatXu deleteById(UUID id) {
        Optional<XuatXu> optional = xuatXuRepository.findById(id);
        return optional.map(o -> {
            xuatXuRepository.delete(o);
            return o;
        }).orElse(null);
    }

    @Override
    public XuatXu details(UUID id) {
        Optional<XuatXu> ag = xuatXuRepository.findById(id);
        return ag.orElse(null);
    }
}

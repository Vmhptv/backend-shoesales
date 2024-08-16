package com.example.bangiay.service.implement;

import com.example.bangiay.entity.ThuongHieu;
import com.example.bangiay.repository.ThuongHieuRepository;
import com.example.bangiay.service.ThuongHieuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ThuongHieuServiceImpl implements ThuongHieuService {

    @Autowired
    private ThuongHieuRepository thuongHieuRepository;

    @Override
    public List<ThuongHieu> getAll() {
        return thuongHieuRepository.findAll();
    }

    @Override
    public ThuongHieu add(ThuongHieu anhGiay) {
        return thuongHieuRepository.save(anhGiay);
    }

    @Override
    public ThuongHieu update(UUID id, ThuongHieu cl) {
        Optional<ThuongHieu> optional = thuongHieuRepository.findById(id);
        return optional.map(o -> {
            o.setTenUrl(cl.getTenUrl());
            o.setMa(cl.getMa());
            o.setTen(cl.getTen());
            o.setTrangThai(cl.getTrangThai());
            return thuongHieuRepository.save(o);
        }).orElse(null);
    }

    @Override
    public ThuongHieu deleteById(UUID id) {
        Optional<ThuongHieu> optional = thuongHieuRepository.findById(id);
        return optional.map(o -> {
            thuongHieuRepository.delete(o);
            return o;
        }).orElse(null);
    }

    @Override
    public ThuongHieu details(UUID id) {
        Optional<ThuongHieu> ag = thuongHieuRepository.findById(id);
        return ag.orElse(null);
    }
}

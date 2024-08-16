package com.example.bangiay.service.implement;

import com.example.bangiay.entity.KieuDang;
import com.example.bangiay.repository.KieuDangRepository;
import com.example.bangiay.service.KieuDangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class KieuDangServiceImpl implements KieuDangService {

    @Autowired
    private KieuDangRepository kieuDangRepository;

    @Override
    public List<KieuDang> getAll() {
        return kieuDangRepository.findAll();
    }

    @Override
    public KieuDang add(KieuDang kieuDang) {
        return kieuDangRepository.save(kieuDang);
    }

    @Override
    public KieuDang update(UUID id, KieuDang cl) {
        Optional<KieuDang> optional = kieuDangRepository.findById(id);
        return optional.map(o -> {
            o.setMa(cl.getMa());
            o.setTen(cl.getTen());
            o.setTrangThai(cl.getTrangThai());
            return kieuDangRepository.save(o);
        }).orElse(null);
    }

    @Override
    public KieuDang deleteById(UUID id) {
        Optional<KieuDang> optional = kieuDangRepository.findById(id);
        return optional.map(o -> {
            kieuDangRepository.delete(o);
            return o;
        }).orElse(null);
    }

    @Override
    public KieuDang details(UUID id) {
        Optional<KieuDang> ag = kieuDangRepository.findById(id);
        return ag.orElse(null);
    }
}

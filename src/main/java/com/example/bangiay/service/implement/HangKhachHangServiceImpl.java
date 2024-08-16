package com.example.bangiay.service.implement;


import com.example.bangiay.entity.HangKhachHang;
import com.example.bangiay.repository.HangKhachHangRepository;
import com.example.bangiay.service.HangKhachHangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class HangKhachHangServiceImpl implements HangKhachHangService {
    @Autowired
    private HangKhachHangRepository hangKhachHangRepository;

    @Override
    public List<HangKhachHang> getAll() {
        return hangKhachHangRepository.findAll();
    }

    @Override
    public HangKhachHang add(HangKhachHang hangKhachHang) {
        return hangKhachHangRepository.save(hangKhachHang);
    }

    @Override
    public HangKhachHang update(UUID id, HangKhachHang hangKhachHang) {
        Optional<HangKhachHang> optional = hangKhachHangRepository.findById(id);
        return optional.map(o ->{

            o.setMa(hangKhachHang.getMa());
            o.setTen(hangKhachHang.getTen());
            o.setTrangThai(hangKhachHang.getTrangThai());
            o.setDieuKien(hangKhachHang.getDieuKien());
            return hangKhachHangRepository.save(o);
        }).orElse(null);
    }

    @Override
    public HangKhachHang deleteById(UUID id) {
        Optional<HangKhachHang>optional= hangKhachHangRepository.findById(id);
        return optional.map(o ->{
            hangKhachHangRepository.delete(o);
            return o;
        }).orElse(null);
    }

    @Override
    public HangKhachHang details(UUID id) {
        Optional<HangKhachHang> hangKhachHang = hangKhachHangRepository.findById(id);
        return hangKhachHang.orElse(null);
    }
}

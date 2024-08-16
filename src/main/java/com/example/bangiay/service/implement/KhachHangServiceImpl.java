package com.example.bangiay.service.implement;


import com.example.bangiay.entity.KhachHang;
import com.example.bangiay.repository.KhachHangRepository;
import com.example.bangiay.service.KhachHangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class KhachHangServiceImpl implements KhachHangService {
    @Autowired
    private KhachHangRepository khachHangRepository;


    @Override
    public List<KhachHang> getAll() {
        return khachHangRepository.findAll();
    }

    @Override
    public KhachHang add(KhachHang khachHang) {
        return khachHangRepository.save(khachHang);
    }

    @Override
    public KhachHang update(UUID id, KhachHang khachHang) {
        Optional<KhachHang> optional = khachHangRepository.findById(id);
        return optional.map(o ->{
            o.setMa(khachHang.getMa());
            o.setHoTen(khachHang.getHoTen());
            o.setTrangThai(khachHang.getTrangThai());
            o.setAnh(khachHang.getAnh());
            o.setEmail(khachHang.getEmail());
            o.setHangKhachHang(khachHang.getHangKhachHang());
            o.setMatKhau(khachHang.getMatKhau());
            o.setNgaySinh(khachHang.getNgaySinh());
            o.setSoDienThoai(khachHang.getSoDienThoai());
            return khachHangRepository.save(o);
        }).orElse(null);
    }

    @Override
    public KhachHang deleteById(UUID id) {
        Optional<KhachHang>optional= khachHangRepository.findById(id);
        return optional.map(o ->{
            khachHangRepository.delete(o);
            return o;
        }).orElse(null);
    }

    @Override
    public KhachHang details(UUID id) {
        Optional<KhachHang> khachHang = khachHangRepository.findById(id);
        return khachHang.orElse(null);
    }
}

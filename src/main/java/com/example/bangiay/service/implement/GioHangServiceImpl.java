package com.example.bangiay.service.implement;

import com.example.bangiay.entity.GioHang;
import com.example.bangiay.entity.GioHangChiTiet;
import com.example.bangiay.repository.GioHangChiTietRepository;
import com.example.bangiay.repository.GioHangRepository;
import com.example.bangiay.service.GioHangChiTietService;
import com.example.bangiay.service.GioHangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class GioHangServiceImpl implements GioHangService {
    @Autowired
    private GioHangRepository reponsitory;

    @Override
    public List<GioHang> getall() {
        return reponsitory.findAll();
    }

    @Override
    public GioHang add(GioHang gioHang) {
        return reponsitory.save(gioHang);
    }

    @Override
    public GioHang update(GioHang gioHang, UUID id) {
        Optional<GioHang> optional= reponsitory.findById(id);
        return optional.map(o ->{
            o.setMa(gioHang.getMa());
            o.setGhiChu(gioHang.getGhiChu());
            o.setTrangThai(gioHang.getTrangThai());
            o.setKhachHang(gioHang.getKhachHang());
            o.setNgayCapNhat(gioHang.getNgayCapNhat());
            o.setNgayTao(gioHang.getNgayTao());
            return reponsitory.save(o);
        }).orElse(null);
    }

    @Override
    public GioHang deleteById(UUID id) {
        Optional<GioHang> optional = reponsitory.findById(id);
        return optional.map(o ->{
            reponsitory.delete(o);
            return o;
        }).orElse(null);
    }

    @Override
    public GioHang details(UUID id) {
        Optional<GioHang> optional = reponsitory.findById(id);
        return optional.orElse(null);
    }
}

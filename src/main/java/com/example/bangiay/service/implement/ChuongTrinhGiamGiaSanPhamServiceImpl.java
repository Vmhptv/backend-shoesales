package com.example.bangiay.service.implement;

import com.example.bangiay.entity.ChuongTrinhGiamGiaSanPham;
import com.example.bangiay.entity.KichCo;
import com.example.bangiay.repository.ChuongTrinhGiamGiaSanPhamRepository;
import com.example.bangiay.service.ChuongTrinhGiamGiaSanPhamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ChuongTrinhGiamGiaSanPhamServiceImpl implements ChuongTrinhGiamGiaSanPhamService {
    @Autowired
    private ChuongTrinhGiamGiaSanPhamRepository reponsitory;
    @Override
    public List<ChuongTrinhGiamGiaSanPham> getAll() {
        return reponsitory.findAll();
    }

    @Override
    public ChuongTrinhGiamGiaSanPham add(ChuongTrinhGiamGiaSanPham chuongTrinhGiamGiaSanPham) {
        return reponsitory.save(chuongTrinhGiamGiaSanPham);
    }

    @Override
    public ChuongTrinhGiamGiaSanPham update(UUID id, ChuongTrinhGiamGiaSanPham chuongTrinhGiamGiaSanPham) {
        Optional<ChuongTrinhGiamGiaSanPham> optional = reponsitory.findById(id);
        return optional.map(o -> {
            o.setMa(chuongTrinhGiamGiaSanPham.getMa());
            o.setNgayBatDau(chuongTrinhGiamGiaSanPham.getNgayBatDau());
            o.setTen(chuongTrinhGiamGiaSanPham.getTen());
            o.setTrangThai(chuongTrinhGiamGiaSanPham.getTrangThai());
            o.setPhanTramGiam(chuongTrinhGiamGiaSanPham.getPhanTramGiam());
            o.setNhanVienUpdate(chuongTrinhGiamGiaSanPham.getNhanVienUpdate());
            o.setNgayKetThuc(chuongTrinhGiamGiaSanPham.getNgayKetThuc());
            o.setNhanVienCreate(chuongTrinhGiamGiaSanPham.getNhanVienCreate());
            return reponsitory.save(o);
        }).orElse(null);
    }

    @Override
    public ChuongTrinhGiamGiaSanPham deleteById(UUID id) {
        Optional<ChuongTrinhGiamGiaSanPham> optional = reponsitory.findById(id);
        return optional.map(o ->{
            reponsitory.delete(o);
            return o;
        }).orElse(null);
    }

    @Override
    public ChuongTrinhGiamGiaSanPham details(UUID id) {
        Optional<ChuongTrinhGiamGiaSanPham> ctr = reponsitory.findById(id);
        return ctr.orElse(null);
    }
}

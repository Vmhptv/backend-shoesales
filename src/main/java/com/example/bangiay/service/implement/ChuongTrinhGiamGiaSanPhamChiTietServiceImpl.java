package com.example.bangiay.service.implement;

import com.example.bangiay.entity.ChuongTrinhGiamGiaChiTietSanPham;
import com.example.bangiay.repository.ChuongTrinhGiamGiaSanPhamChiTietRepository;
import com.example.bangiay.service.ChuongTrinhGiamGiaSanPhamChiTietService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ChuongTrinhGiamGiaSanPhamChiTietServiceImpl implements ChuongTrinhGiamGiaSanPhamChiTietService {
    @Autowired
    private ChuongTrinhGiamGiaSanPhamChiTietRepository reponsitory;
    @Override
    public List<ChuongTrinhGiamGiaChiTietSanPham> getAll() {
        return reponsitory.findAll();
    }

    @Override
    public ChuongTrinhGiamGiaChiTietSanPham add(ChuongTrinhGiamGiaChiTietSanPham chuongTrinhGiamGiaChiTietSanPham) {
        return reponsitory.save(chuongTrinhGiamGiaChiTietSanPham);
    }

    @Override
    public ChuongTrinhGiamGiaChiTietSanPham update(UUID id, ChuongTrinhGiamGiaChiTietSanPham chuongTrinhGiamGiaChiTietSanPham) {
        Optional<ChuongTrinhGiamGiaChiTietSanPham> optional = reponsitory.findById(id);
        return optional.map(o ->{
            o.setSoTienDaGiam(chuongTrinhGiamGiaChiTietSanPham.getSoTienDaGiam());
            o.setTrangThai(chuongTrinhGiamGiaChiTietSanPham.getTrangThai());
            o.setCtggsp(chuongTrinhGiamGiaChiTietSanPham.getCtggsp());
            o.setGiay(chuongTrinhGiamGiaChiTietSanPham.getGiay());
            return  reponsitory.save(o);
        }).orElse(null);
    }

    @Override
    public ChuongTrinhGiamGiaChiTietSanPham deleteById(UUID id) {
        Optional<ChuongTrinhGiamGiaChiTietSanPham> optional = reponsitory.findById(id);
        return optional.map(o ->{
            reponsitory.delete(o);
            return o;
        }).orElse(null);
    }

    @Override
    public ChuongTrinhGiamGiaChiTietSanPham details(UUID id) {
        Optional<ChuongTrinhGiamGiaChiTietSanPham> CTR = reponsitory.findById(id);
        return CTR.orElse(null);
    }
}

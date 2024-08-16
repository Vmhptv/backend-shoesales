package com.example.bangiay.service.implement;

import com.example.bangiay.entity.DiaChi;
import com.example.bangiay.entity.HoaDon;
import com.example.bangiay.entity.KhachHang;
import com.example.bangiay.repository.DiaChiRepository;
import com.example.bangiay.service.DiaChiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class DiaChiServiceImpl implements DiaChiService {
    @Autowired
    private DiaChiRepository diaChiRepository;

    @Override
    public List<DiaChi> getAll() {
        return diaChiRepository.findAll();
    }

    @Override
    public Optional<DiaChi> getDiaChiById(UUID id) {
        return diaChiRepository.findById(id);
    }

    @Override
    public List<DiaChi> getDiaChiByIdKhachHang(UUID idKhachHang) {
        return diaChiRepository.findByIdKhachHang(idKhachHang);
    }

    @Override
    public DiaChi createDiaChi(DiaChi diaChi) {
        return diaChiRepository.save(diaChi);
    }

    @Override
    public DiaChi updateDiaChi(UUID id, DiaChi diaChi) {
        Optional<DiaChi> optionalDiaChi = diaChiRepository.findById(id);
        if (optionalDiaChi.isPresent()) {
            DiaChi diaChi1 = optionalDiaChi.get();

            diaChi1.setKhachHang(diaChi.getKhachHang());
            diaChi1.setMa(diaChi.getMa());
            diaChi1.setTenDiaChi(diaChi.getTenDiaChi());
            diaChi1.setTenNguoiNhan(diaChi.getTenNguoiNhan());
            diaChi1.setSdtNguoiNhan(diaChi.getSdtNguoiNhan());
            diaChi1.setXa(diaChi.getXa());
            diaChi1.setHuyen(diaChi.getHuyen());
            diaChi1.setThanhPho(diaChi.getThanhPho());
            diaChi1.setTrangThai(diaChi.getTrangThai());

            return diaChiRepository.save(diaChi1);
        } else {
            return null;
        }
    }

    @Override
    public boolean deleteDiaChi(UUID id) {
        Optional<DiaChi> optionalDiaChi = diaChiRepository.findById(id);
        if (optionalDiaChi.isPresent()) {
            diaChiRepository.delete(optionalDiaChi.get());
            return true;
        } else {
            return false;
        }
    }
}

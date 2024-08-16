package com.example.bangiay.service.implement;

import com.example.bangiay.entity.NhanVien;
import com.example.bangiay.repository.NhanVienRepository;
import com.example.bangiay.service.NhanVienService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class NhanVienServiceImpl implements NhanVienService {
    @Autowired
    private NhanVienRepository nhanVienRepository;

    @Override
    public List<NhanVien> getAll() {
        return nhanVienRepository.findAll();
    }

    @Override
    public NhanVien add(NhanVien nhanVien) {
        return nhanVienRepository.save(nhanVien);
    }

    @Override
    public NhanVien update(UUID id, NhanVien nhanVien) {
        Optional<NhanVien> optional = nhanVienRepository.findById(id);
        return optional.map(o ->{
            o.setMa(nhanVien.getMa());
            o.setHoTen(nhanVien.getHoTen());
            o.setTrangThai(nhanVien.getTrangThai());
            o.setAnh(nhanVien.getAnh());
            o.setEmail(nhanVien.getEmail());
            o.setChucVu(nhanVien.getChucVu());
            o.setMatKhau(nhanVien.getMatKhau());
            o.setNgaySinh(nhanVien.getNgaySinh());
            o.setSoDienThoai(nhanVien.getSoDienThoai());
            o.setDiaChi(nhanVien.getDiaChi());
            o.setHuyen(nhanVien.getHuyen());
            o.setNgayNghiViec(nhanVien.getNgayNghiViec());
            o.setNgaySinh(nhanVien.getNgaySinh());
            o.setNgayVaoLam(nhanVien.getNgayVaoLam());
            o.setThanhPho(nhanVien.getThanhPho());
            o.setXa(nhanVien.getXa());
            return nhanVienRepository.save(o);
        }).orElse(null);
    }

    @Override
    public NhanVien deleteById(UUID id) {
        Optional<NhanVien>optional= nhanVienRepository.findById(id);
        return optional.map(o ->{
            nhanVienRepository.delete(o);
            return o;
        }).orElse(null);
    }

    @Override
    public NhanVien details(UUID id) {
        Optional<NhanVien> nhanVien = nhanVienRepository.findById(id);
        return nhanVien.orElse(null);
    }
}


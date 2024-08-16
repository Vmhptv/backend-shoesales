package com.example.bangiay.service.implement;

import com.example.bangiay.entity.*;
import com.example.bangiay.repository.*;
import com.example.bangiay.service.GiayService;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class GiayServiceImpl implements GiayService {

    @Autowired
    private GiayRepository giayRepository;

    @Override
    public List<Giay> getAll() {
        return giayRepository.findAll();
    }

    @Override
    public Giay add(Giay giay) {
        return giayRepository.save(giay);
    }

    @Override
    public Giay update(UUID id, Giay giay) {
        Optional<Giay> optional=giayRepository.findById(id);
        return optional.map(o -> {
            o.setMa(giay.getMa());
            o.setTen(giay.getTen());
            o.setMoTa(giay.getMoTa());
            o.setGiaNhap(giay.getGiaNhap());
            o.setGiaBan(giay.getGiaBan());
            o.setGiaSauKhuyenMai(giay.getGiaSauKhuyenMai());
            o.setDoHot(giay.getDoHot());
            o.setTrangThai(giay.getTrangThai());
            o.setThuongHieu(giay.getThuongHieu());
            o.setChatLieu(giay.getChatLieu());
            o.setDeGiay(giay.getDeGiay());
            o.setXuatXu(giay.getXuatXu());
            o.setKieuDang(giay.getKieuDang());
            o.setMauSac(giay.getMauSac());
            o.setKichCo(giay.getKichCo());
            o.setAnhGiay(giay.getAnhGiay());
            return giayRepository.save(o);
        }).orElse(null);
    }

    @Override
    public Giay deleteById(UUID id) {
        Optional<Giay> optional = giayRepository.findById(id);
        return optional.map(o -> {
            giayRepository.delete(o);
            return o;
        }).orElse(null);
    }

    @Override
    public Giay details(UUID id) {
        Optional<Giay> ag = giayRepository.findById(id);
        return ag.orElse(null);
    }
}

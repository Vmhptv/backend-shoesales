package com.example.bangiay.service.implement;

import com.example.bangiay.entity.GiayChiTiet;
import com.example.bangiay.repository.GiayChiTietRepository;
import com.example.bangiay.service.GiayChiTietService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class GiayChiTietServiceImpl implements GiayChiTietService {
    @Autowired
    private GiayChiTietRepository reponsitory;
    @Override
    public List<GiayChiTiet> getAll() {
        return reponsitory.findAll();
    }

    @Override
    public GiayChiTiet add(GiayChiTiet giayChiTiet) {
        return reponsitory.save(giayChiTiet);
    }

    @Override
    public GiayChiTiet update(UUID id, GiayChiTiet giayChiTiet) {
        Optional<GiayChiTiet> optional = reponsitory.findById(id);
        return optional.map(o ->{
            o.setGiay(giayChiTiet.getGiay());
            o.setSoLuongTon(giayChiTiet.getSoLuongTon());
            o.setTrangThai(giayChiTiet.getTrangThai());
            return  reponsitory.save(o);
        }).orElse(null);
    }

    @Override
    public GiayChiTiet deleteById(UUID id) {
        Optional<GiayChiTiet> optional = reponsitory.findById(id);
        return optional.map(o ->{
            reponsitory.delete(o);
            return o;
        }).orElse(null);
    }

    @Override
    public GiayChiTiet details(UUID id) {
        Optional<GiayChiTiet> optional = reponsitory.findById(id);
        return optional.orElse(null);
    }

    @Override
    public void updateStockQuantity(UUID id, Integer quantity, boolean isAdding) {
        GiayChiTiet giayChiTiet = reponsitory.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product not found for this id :: " + id));
        if (isAdding) {
            giayChiTiet.setSoLuongTon(giayChiTiet.getSoLuongTon() + quantity);
        } else {
            giayChiTiet.setSoLuongTon(giayChiTiet.getSoLuongTon() - quantity);
        }
        reponsitory.save(giayChiTiet);
    }
}

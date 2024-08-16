package com.example.bangiay.service.implement;

import com.example.bangiay.entity.DanhMuc;
import com.example.bangiay.repository.DanhMucRepository;
import com.example.bangiay.service.DanhMucService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class DanhMucServiceImpl implements DanhMucService {

    @Autowired
    private DanhMucRepository danhMucRepository;

    @Override
    public List<DanhMuc> getAll() {
        return danhMucRepository.findAll();
    }

    @Override
    public DanhMuc add(DanhMuc danhMuc) {
        return danhMucRepository.save(danhMuc);
    }

    @Override
    public DanhMuc update(UUID id, DanhMuc dm) {
        Optional<DanhMuc> optional = danhMucRepository.findById(id);
        return optional.map(o -> {
            o.setGiay(dm.getGiay());
            o.setMa(dm.getMa());
            o.setTen(dm.getTen());
            o.setTrangThai(dm.getTrangThai());
            return danhMucRepository.save(o);
        }).orElse(null);
    }

    @Override
    public DanhMuc deleteById(UUID id) {
        Optional<DanhMuc> optional = danhMucRepository.findById(id);
        return optional.map(o -> {
            danhMucRepository.delete(o);
            return o;
        }).orElse(null);
    }

    @Override
    public DanhMuc details(UUID id) {
        Optional<DanhMuc> ag = danhMucRepository.findById(id);
        return ag.orElse(null);
    }
}

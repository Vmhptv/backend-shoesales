package com.example.bangiay.service.implement;

import com.example.bangiay.entity.DanhMuc;
import com.example.bangiay.entity.MauSac;
import com.example.bangiay.repository.MauSacRepository;
import com.example.bangiay.service.DanhMucService;
import com.example.bangiay.service.MauSacService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class MauSacServiceImpl implements MauSacService {

    @Autowired
    private MauSacRepository mauSacRepository;

    @Override
    public List<MauSac> getAll() {
        return mauSacRepository.findAll();
    }

    @Override
    public MauSac add(MauSac mauSac) {
        return mauSacRepository.save(mauSac);
    }

    @Override
    public MauSac update(UUID id, MauSac cl) {
        Optional<MauSac> optional = mauSacRepository.findById(id);
        return optional.map(o -> {
            o.setMa(cl.getMa());
            o.setTen(cl.getTen());
            o.setTrangThai(cl.getTrangThai());
            return mauSacRepository.save(o);
        }).orElse(null);
    }

    @Override
    public MauSac deleteById(UUID id) {
        Optional<MauSac> optional = mauSacRepository.findById(id);
        return optional.map(o -> {
            mauSacRepository.delete(o);
            return o;
        }).orElse(null);
    }

    @Override
    public MauSac details(UUID id) {
        Optional<MauSac> ag = mauSacRepository.findById(id);
        return ag.orElse(null);
    }
}

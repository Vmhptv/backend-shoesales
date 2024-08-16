package com.example.bangiay.service.implement;


import com.example.bangiay.entity.ChucVu;
import com.example.bangiay.repository.ChucVuRepository;
import com.example.bangiay.service.ChucVuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ChucVuServiceImpl implements ChucVuService {
    @Autowired
    private ChucVuRepository chucVuRepository;
    @Override
    public List<ChucVu> getAll() {
        return chucVuRepository.findAll();
    }

    @Override
    public ChucVu add(ChucVu chucVu) {
        return chucVuRepository.save(chucVu);
    }

    @Override
    public ChucVu update(UUID id, ChucVu chucVu) {
        Optional<ChucVu> optional = chucVuRepository.findById(id);
        return optional.map(o ->{
            o.setMa(chucVu.getMa());
            o.setTen(chucVu.getTen());
            o.setTrangThai(chucVu.getTrangThai());
            return chucVuRepository.save(o);
        }).orElse(null);
    }

    @Override
    public ChucVu deleteById(UUID id) {
        Optional<ChucVu>optional= chucVuRepository.findById(id);
        return optional.map(o ->{
            chucVuRepository.delete(o);
            return o;
        }).orElse(null);
    }
    @Override
    public ChucVu details(UUID id) {
        Optional<ChucVu> chucVu = chucVuRepository.findById(id);
        return chucVu.orElse(null);
    }
}

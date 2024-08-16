package com.example.bangiay.service.implement;

import com.example.bangiay.entity.GioHang;
import com.example.bangiay.entity.KichCo;
import com.example.bangiay.repository.GioHangRepository;
import com.example.bangiay.repository.KichCoRepository;
import com.example.bangiay.service.GioHangService;
import com.example.bangiay.service.KichCoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class KichCoServiceImpl implements KichCoService {
    @Autowired
    private KichCoRepository repository;
    @Override
    public List<KichCo> getall() {
        return repository.findAll();
    }

    @Override
    public KichCo add(KichCo kichCo) {
        return repository.save(kichCo);
    }

    @Override
    public KichCo update(KichCo kichCo, UUID id) {
        Optional<KichCo> optional = repository.findById(id);
        return optional.map(o ->{
            o.setMa(kichCo.getMa());
            o.setTen(kichCo.getTen());
            o.setTrangThai(kichCo.getTrangThai());
            return repository.save(o);
        }).orElse(null);
    }

    @Override
    public KichCo deleteById(UUID id) {
        Optional<KichCo> optional = repository.findById(id);
        return optional.map( o ->{
            repository.delete(o);
            return o;
        }).orElse(null);
    }

    @Override
    public KichCo details(UUID id) {
        Optional<KichCo> optional = repository.findById(id);
        return optional.orElse(null);
    }
}

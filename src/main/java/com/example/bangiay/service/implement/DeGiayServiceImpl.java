package com.example.bangiay.service.implement;

import com.example.bangiay.entity.DeGiay;
import com.example.bangiay.repository.DeGiayRepository;
import com.example.bangiay.service.DeGiayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class DeGiayServiceImpl implements DeGiayService {

    @Autowired
    private DeGiayRepository deGiayRepository;

    @Override
    public List<DeGiay> getAll() {
        return deGiayRepository.findAll();
    }

    @Override
    public DeGiay add(DeGiay deGiay) {
        return deGiayRepository.save(deGiay);
    }

    @Override
    public DeGiay update(UUID id, DeGiay dg) {
        Optional<DeGiay> optional = deGiayRepository.findById(id);
        return optional.map(o -> {
            o.setMa(dg.getMa());
            o.setTen(dg.getTen());
            o.setTrangThai(dg.getTrangThai());
            return deGiayRepository.save(o);
        }).orElse(null);
    }

    @Override
    public DeGiay deleteById(UUID id) {
        Optional<DeGiay> optional = deGiayRepository.findById(id);
        return optional.map(o -> {
            deGiayRepository.delete(o);
            return o;
        }).orElse(null);
    }

    @Override
    public DeGiay details(UUID id) {
        Optional<DeGiay> ag = deGiayRepository.findById(id);
        return ag.orElse(null);
    }
}

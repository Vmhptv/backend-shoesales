package com.example.bangiay.service.implement;

import com.example.bangiay.entity.AnhGiay;
import com.example.bangiay.repository.AnhGiayRepository;
import com.example.bangiay.service.AnhGiayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class AnhGiayServiceImpl implements AnhGiayService {

    @Autowired
    private AnhGiayRepository anhGiayRepository;

    @Override
    public List<AnhGiay> getAll() {
        return anhGiayRepository.findAll();
    }

    @Override
    public AnhGiay add(AnhGiay anhGiay) {
        return anhGiayRepository.save(anhGiay);
    }

    @Override
    public AnhGiay update(UUID id, AnhGiay ag) {
        Optional<AnhGiay> optional = anhGiayRepository.findById(id);
        return optional.map(o -> {
            o.setTenUrl(ag.getTenUrl());
            o.setTrangThai(ag.getTrangThai());
            return anhGiayRepository.save(o);
        }).orElse(null);
    }

    @Override
    public AnhGiay deleteById(UUID id) {
        Optional<AnhGiay> optional = anhGiayRepository.findById(id);
        return optional.map(o -> {
            anhGiayRepository.delete(o);
            return o;
        }).orElse(null);
    }

    @Override
    public AnhGiay details(UUID id) {
        Optional<AnhGiay> ag = anhGiayRepository.findById(id);
        return ag.orElse(null);
    }
}

package com.example.bangiay.controller;

import com.example.bangiay.entity.KieuDang;
import com.example.bangiay.service.KieuDangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/kieudang")
public class KieuDangController {
    @Autowired
    private KieuDangService service;

    @GetMapping()
    public ResponseEntity<?> getAll(){
        return ResponseEntity.ok(service.getAll());
    }

    @PostMapping("/add")
    public ResponseEntity<?> add(@RequestBody KieuDang kieuDang){
        return ResponseEntity.ok(service.add(kieuDang));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable UUID id, @RequestBody KieuDang kieuDang){
        return ResponseEntity.ok(service.update(id, kieuDang));
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity update(@PathVariable UUID id){
        return ResponseEntity.ok(service.deleteById(id));
    }
}

package com.example.bangiay.controller;

import com.example.bangiay.entity.KhachHang;
import com.example.bangiay.service.KhachHangService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/khachHang")
public class KhachHangController {
    @Autowired
    private KhachHangService khachHangService;
    @GetMapping()
    public ResponseEntity<?> getAll(){
        return ResponseEntity.ok(khachHangService.getAll());
    }
    @PostMapping("/add")
    public ResponseEntity<?> add(@RequestBody KhachHang khachHang){
        return ResponseEntity.ok(khachHangService.add(khachHang));
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable UUID id,@RequestBody KhachHang khachHang){
        return ResponseEntity.ok(khachHangService.update(id,khachHang));
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable UUID id){
        return ResponseEntity.ok(khachHangService.deleteById(id));
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<?> detail(@PathVariable UUID id){
        return ResponseEntity.ok(khachHangService.details(id));
    }
}

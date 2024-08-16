package com.example.bangiay.controller;

import com.example.bangiay.entity.NhanVien;
import com.example.bangiay.service.NhanVienService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/nhanVien")
public class NhanVienController {
    @Autowired
    private NhanVienService nhanVienService;
    @GetMapping()
    public ResponseEntity<?> getAll(){
        return ResponseEntity.ok(nhanVienService.getAll());
    }
    @PostMapping("/add")
    public ResponseEntity<?> add(@RequestBody NhanVien NhanVien){
        return ResponseEntity.ok(nhanVienService.add(NhanVien));
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable UUID id, @RequestBody NhanVien NhanVien){
        return ResponseEntity.ok(nhanVienService.update(id,NhanVien));
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable UUID id){
        return ResponseEntity.ok(nhanVienService.deleteById(id));
    }
    @GetMapping("/detail/{id}")
    public ResponseEntity<?> detail(@PathVariable UUID id){
        return ResponseEntity.ok(nhanVienService.details(id));
    }
}

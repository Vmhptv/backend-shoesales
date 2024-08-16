package com.example.bangiay.controller;

import com.example.bangiay.entity.GioHangChiTiet;
import com.example.bangiay.service.GioHangChiTietService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/giohangchitiet")
public class GioHangChiTietController {
    @Autowired
    private GioHangChiTietService service;
    @GetMapping
    public ResponseEntity<?> getall(){
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("/khachhang/{khachHangId}")
    public ResponseEntity<List<GioHangChiTiet>> getByKhachHangId(@PathVariable UUID khachHangId){
        return ResponseEntity.ok(service.getByKhachHangId(khachHangId));
    }
//    @PostMapping
//    public ResponseEntity<?> add(@RequestBody GioHangChiTiet gioHangChiTiet){
//        return ResponseEntity.ok(service.add(gioHangChiTiet));
//    }
//    @PutMapping
//    public  ResponseEntity<?> update(@RequestBody GioHangChiTiet gioHangChiTiet, @PathVariable UUID id){
//        return ResponseEntity.ok(service.update(gioHangChiTiet,id));
//    }
//    @DeleteMapping("/delete/{id}")
//    public ResponseEntity<?> delete(@PathVariable UUID id){
//        return ResponseEntity.ok(service.deleteById(id));
//    }
}

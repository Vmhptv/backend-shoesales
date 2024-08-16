package com.example.bangiay.controller;

import com.example.bangiay.service.ChuongTrinhGiamGiaSanPhamChiTietService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/fivebee/ChuongTrinhGiamGiaSanPhamChiTiet")
public class ChuongTrinhGiamGiaSanPhamChiTietController {
    @Autowired
    private ChuongTrinhGiamGiaSanPhamChiTietService service;
    @GetMapping
    public ResponseEntity<?> getall(){
        return ResponseEntity.ok(service.getAll());
    }
//    @PostMapping("/add")
//    public ResponseEntity<?> add(@RequestBody ChuongTrinhGiamGiaChiTietSanPham chuongTrinhGiamGiaChiTietSanPham){
//        return  ResponseEntity.ok(service.add(chuongTrinhGiamGiaChiTietSanPham));
//    }
//    @PutMapping("/update/{id}")
//    public  ResponseEntity<?> update(@PathVariable UUID id,@RequestBody ChuongTrinhGiamGiaChiTietSanPham chuongTrinhGiamGiaChiTietSanPham){
//        return  ResponseEntity.ok(service.update(chuongTrinhGiamGiaChiTietSanPham,id));
//    }
//    @DeleteMapping("/delete/{id}")
//    public ResponseEntity<?> delete(@PathVariable UUID id){
//        return ResponseEntity.ok(service.deleteByID(id));
//    }
}

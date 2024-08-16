package com.example.bangiay.controller;

import com.example.bangiay.service.GioHangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/GioHang")
public class GioHangController {
    @Autowired
    private GioHangService service;
    @GetMapping
    public ResponseEntity<?> getall(){
        return ResponseEntity.ok(service.getall());
    }
//    @PostMapping("/add")
//    public ResponseEntity<?> add(@RequestBody GioHang gioHang){
//        return  ResponseEntity.ok(service.add(gioHang));
//    }
//    @PutMapping("update/{id}")
//    public ResponseEntity<?> update(@RequestBody GioHang gioHang, @PathVariable UUID id){
//        return ResponseEntity.ok(service.update(gioHang,id));
//    }
//    @DeleteMapping("delete/{id}")
//    public ResponseEntity<?> delete(@PathVariable UUID id){
//        return  ResponseEntity.ok((service.deleteById(id)));
//    }
}

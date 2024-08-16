package com.example.bangiay.controller;

import com.example.bangiay.entity.HangKhachHang;
import com.example.bangiay.service.HangKhachHangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/hangKhachHang")
public class HangKhachHangController {
    @Autowired
    private HangKhachHangService hangKhachHangService;
    @GetMapping()
    public ResponseEntity<?> getAll(){
        return ResponseEntity.ok(hangKhachHangService.getAll());
    }
    @PostMapping("/add")
    public ResponseEntity<?> add(@RequestBody HangKhachHang hangKhachHang){
        return ResponseEntity.ok(hangKhachHangService.add(hangKhachHang));
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable UUID id , @RequestBody HangKhachHang hangKhachHang){
        return ResponseEntity.ok(hangKhachHangService.update(id,hangKhachHang));
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable UUID id){
        return ResponseEntity.ok(hangKhachHangService.deleteById(id));
    }
    @GetMapping("/detail/{id}")
    public ResponseEntity<?> detail(@PathVariable UUID id){
        return ResponseEntity.ok(hangKhachHangService.details(id));
    }
}

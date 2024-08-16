package com.example.bangiay.controller;

import com.example.bangiay.entity.GiayChiTiet;
import com.example.bangiay.service.GiayChiTietService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/GiayChiTiet")
public class GiayChiTietController {
    @Autowired
    private GiayChiTietService service;
    @GetMapping
    public ResponseEntity<?> getall(){
        return ResponseEntity.ok(service.getAll());
    }
    @PostMapping("/add")
    public ResponseEntity<?> add(@RequestBody GiayChiTiet giayChiTiet){
       return ResponseEntity.ok(service.add(giayChiTiet));
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable UUID id,@RequestBody GiayChiTiet giayChiTiet ){
        return ResponseEntity.ok(service.update(id,giayChiTiet));
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable UUID id){
        return ResponseEntity.ok(service.deleteById(id));
    }
    @GetMapping("/detail/{id}")
    public ResponseEntity<?> detail(@PathVariable UUID id){
        return ResponseEntity.ok(service.details(id));
    }
    @PutMapping("/update-stock/{id}")
    public ResponseEntity<?> updateStockQuantity(@PathVariable UUID id, @RequestParam Integer quantity, @RequestParam boolean isAdding) {
        service.updateStockQuantity(id, quantity, isAdding);
        return ResponseEntity.ok().build();
    }
}

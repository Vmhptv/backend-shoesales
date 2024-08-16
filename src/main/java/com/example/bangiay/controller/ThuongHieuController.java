package com.example.bangiay.controller;

import com.example.bangiay.entity.ThuongHieu;
import com.example.bangiay.service.ThuongHieuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/thuonghieu")
public class ThuongHieuController {
    @Autowired
    private ThuongHieuService service;

    @GetMapping()
    public ResponseEntity<?> getAll(){
        return ResponseEntity.ok(service.getAll());
    }

    @PostMapping("/add")
    public ResponseEntity<?> add(@RequestBody ThuongHieu chatLieu){
        return ResponseEntity.ok(service.add(chatLieu));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable UUID id, @RequestBody ThuongHieu thuongHieu){
        return ResponseEntity.ok(service.update(id, thuongHieu));
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity update(@PathVariable UUID id){
        return ResponseEntity.ok(service.deleteById(id));
    }
}

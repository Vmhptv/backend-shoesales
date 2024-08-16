package com.example.bangiay.controller;

import com.example.bangiay.entity.KieuDang;
import com.example.bangiay.entity.XuatXu;
import com.example.bangiay.service.KieuDangService;
import com.example.bangiay.service.XuatXuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/xuatxu")
public class XuatXuController {
    @Autowired
    private XuatXuService service;

    @GetMapping()
    public ResponseEntity<?> getAll(){
        return ResponseEntity.ok(service.getAll());
    }

    @PostMapping("/add")
    public ResponseEntity<?> add(@RequestBody XuatXu xuatXu){
        return ResponseEntity.ok(service.add(xuatXu));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable UUID id, @RequestBody XuatXu xuatXu){
        return ResponseEntity.ok(service.update(id, xuatXu));
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity update(@PathVariable UUID id){
        return ResponseEntity.ok(service.deleteById(id));
    }
}

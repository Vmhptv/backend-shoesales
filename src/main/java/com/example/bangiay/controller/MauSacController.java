package com.example.bangiay.controller;

import com.example.bangiay.entity.MauSac;
import com.example.bangiay.entity.XuatXu;
import com.example.bangiay.service.MauSacService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Controller
@CrossOrigin("*")
@RequestMapping("/api/mausac")
public class MauSacController {
    @Autowired
    private MauSacService mauSacService;
    @GetMapping()
    public ResponseEntity<?> getAll(){
        return ResponseEntity.ok(mauSacService.getAll());
    }
    @PostMapping("/add")
    public ResponseEntity<?> add(@RequestBody MauSac mauSac){
        return ResponseEntity.ok(mauSacService.add(mauSac));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable UUID id, @RequestBody MauSac mauSac){
        return ResponseEntity.ok(mauSacService.update(id, mauSac));
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity update(@PathVariable UUID id){
        return ResponseEntity.ok(mauSacService.deleteById(id));
    }
}

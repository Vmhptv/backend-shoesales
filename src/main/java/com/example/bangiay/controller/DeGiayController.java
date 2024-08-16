package com.example.bangiay.controller;

import com.example.bangiay.entity.DeGiay;
import com.example.bangiay.service.DeGiayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/degiay")
public class DeGiayController {
    @Autowired
    private DeGiayService service;

    @GetMapping()
    public ResponseEntity<?> getAll(){
        return ResponseEntity.ok(service.getAll());
    }

    @PostMapping("/add")
    public ResponseEntity<?> add(@RequestBody DeGiay deGiay){
        return ResponseEntity.ok(service.add(deGiay));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable UUID id, @RequestBody DeGiay deGiay){
        return ResponseEntity.ok(service.update(id, deGiay));
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity update(@PathVariable UUID id){
        return ResponseEntity.ok(service.deleteById(id));
    }
}

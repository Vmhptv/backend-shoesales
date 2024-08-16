package com.example.bangiay.controller;

import com.example.bangiay.entity.Giay;
import com.example.bangiay.entity.MauSac;
import com.example.bangiay.service.GiayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Controller
@CrossOrigin("*")
@RequestMapping("/api/giay")
public class GiayController {
    @Autowired
    private GiayService giayService;

    @GetMapping()
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(giayService.getAll());
    }

    @PostMapping("/add")
    public ResponseEntity<?> add(@RequestBody Giay giay) {
        return ResponseEntity.ok(giayService.add(giay));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Giay> updateGiay(@PathVariable UUID id, @RequestBody Giay giay) {
        return ResponseEntity.ok(giayService.update(id, giay));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity update(@PathVariable UUID id) {
        return ResponseEntity.ok(giayService.deleteById(id));
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity detail(@PathVariable UUID id) {
        return ResponseEntity.ok(giayService.details(id));
    }
}

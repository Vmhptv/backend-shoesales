package com.example.bangiay.controller;

import com.example.bangiay.entity.ChucVu;
import com.example.bangiay.service.ChucVuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/chucVu")
public class ChucVuController {
    @Autowired
    private ChucVuService chucVuService;

    @GetMapping()
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(chucVuService.getAll());
    }

    @PostMapping("/add")
    public ResponseEntity<?> add(@RequestBody ChucVu chucVu) {
        return ResponseEntity.ok(chucVuService.add(chucVu));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable UUID id, @RequestBody ChucVu chucVu) {
        return ResponseEntity.ok(chucVuService.update(id, chucVu));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable UUID id) {
        return ResponseEntity.ok(chucVuService.deleteById(id));
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<?> detail(@PathVariable UUID id){
        return ResponseEntity.ok(chucVuService.details(id));
    }
}

package com.example.bangiay.controller;

import com.example.bangiay.entity.DiaChi;
import com.example.bangiay.service.DiaChiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/diachi")
public class DiaChiController {
    @Autowired
    DiaChiService diaChiService;

    @GetMapping("")
    public ResponseEntity<?> getAll(){
        return ResponseEntity.ok(diaChiService.getAll());
    }

    @GetMapping("/khachhang/{idKhachHang}")
    public ResponseEntity<List<DiaChi>> getDiaChiByIdKhachHang(@PathVariable UUID idKhachHang) {
        List<DiaChi> diaChis = diaChiService.getDiaChiByIdKhachHang(idKhachHang);
        return new ResponseEntity<>(diaChis, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> getOrderById(@PathVariable UUID id){
        Optional<DiaChi> diaChi = diaChiService.getDiaChiById(id);
        if (diaChi.isPresent()) {
            return ResponseEntity.ok(diaChi.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @PostMapping("/add")
    public ResponseEntity<DiaChi> createOrder(@RequestBody DiaChi diaChi) {
        DiaChi createDiaChi = diaChiService.createDiaChi(diaChi);
        return new ResponseEntity<DiaChi>(createDiaChi, HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    public ResponseEntity<DiaChi> updateInvoice(@PathVariable UUID id, @RequestBody DiaChi diaChiDetails) {
        DiaChi updatedDiaChi = diaChiService.updateDiaChi(id, diaChiDetails);
        return ResponseEntity.ok(updatedDiaChi);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteOrder(@PathVariable UUID id) {
        diaChiService.deleteDiaChi(id);
        return ResponseEntity.noContent().build();
    }
}

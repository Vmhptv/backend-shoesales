package com.example.bangiay.controller;

import com.example.bangiay.entity.HoaDonChiTiet;
import com.example.bangiay.service.implement.HoaDonChiTietServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/hoadonchitiet")
public class HoaDonChitTietController {
    @Autowired
    public HoaDonChiTietServiceImpl service;
    @GetMapping
    public ResponseEntity<?> getall(){
        return ResponseEntity.ok(service.getall());
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> getOrderDetailById(@PathVariable UUID id){
        Optional<HoaDonChiTiet> orderDetail = service.details(id);
        if (orderDetail.isPresent()) {
            return ResponseEntity.ok(orderDetail.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @PostMapping("/add")
    public ResponseEntity<HoaDonChiTiet> createOrderDetail(@RequestBody HoaDonChiTiet orderDetail) {
        HoaDonChiTiet createHoaDonChiTiet = service.add(orderDetail);
        return new ResponseEntity<>(createHoaDonChiTiet, HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    public ResponseEntity<HoaDonChiTiet> updateInvoice(@PathVariable UUID id, @RequestBody HoaDonChiTiet orderDetails) {
        HoaDonChiTiet updatedOrder = service.update(id, orderDetails);
        return ResponseEntity.ok(updatedOrder);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteOrder(@PathVariable UUID id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}

package com.example.bangiay.controller;

import com.example.bangiay.entity.HoaDon;
import com.example.bangiay.service.implement.HoaDonServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/hoadon")
public class HoaDonController {
    @Autowired
    private HoaDonServiceImpl service;

    @GetMapping("")
    public ResponseEntity<?> getAll(){
        return ResponseEntity.ok(service.getAll());
    }
    @GetMapping("/khachHang/{khachHangId}")
    public ResponseEntity<List<HoaDon>> getHoaDonByKhachHangId(@PathVariable UUID khachHangId) {
        List<HoaDon> hoaDons = service.getHoaDonByKhachHangId(khachHangId);
        return new ResponseEntity<>(hoaDons, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<HoaDon> getOrderById(@PathVariable UUID id){
        Optional<HoaDon> order = service.getOrderById(id);
        if (order.isPresent()) {
            return ResponseEntity.ok(order.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @PostMapping("/add/khachhang/{khachhangid}")
    public ResponseEntity<HoaDon> createOrder(@PathVariable UUID khachhangid,@RequestBody HoaDon order) {
        HoaDon createHoaDon = service.createOrder(order,khachhangid);
        return new ResponseEntity<HoaDon>(createHoaDon, HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    public ResponseEntity<HoaDon> updateInvoice(@PathVariable UUID id, @RequestBody HoaDon orderDetails) {
        HoaDon updatedOrder = service.updateOrder(id, orderDetails);
        return ResponseEntity.ok(updatedOrder);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteOrder(@PathVariable UUID id) {
        service.deleteOrder(id);
        return ResponseEntity.noContent().build();
    }
}

package com.example.bangiay.controller;

import com.example.bangiay.entity.AnhGiay;
import com.example.bangiay.entity.DeGiay;
import com.example.bangiay.service.AnhGiayService;
import com.example.bangiay.service.DeGiayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/anhgiay")
public class AnhGiayController {
    @Autowired
    private AnhGiayService service;
    //    dùng để chứa đường dẫn tới thư mục lưu trữ
    private final Path fileStorageLocation = Paths.get("src/main/resources/static/upload");

    @GetMapping()
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @PostMapping("/add")
    public ResponseEntity<?> add(@RequestParam("file") MultipartFile file) {
        try {
            // lưu ảnh vào thư mục
            byte[] bytes = file.getBytes();
            Path path = fileStorageLocation.resolve(file.getOriginalFilename());
            Files.write(path, bytes);

            // lưu tên ảnh vào csdl
            AnhGiay anhGiay = new AnhGiay();
            anhGiay.setTenUrl(file.getOriginalFilename());
            service.add(anhGiay);

            return ResponseEntity.ok("thanh cong");
        } catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("upload that bai");
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity update(@PathVariable UUID id) {
        return ResponseEntity.ok(service.deleteById(id));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable UUID id, @RequestParam("trangThai") Integer trangThai, @RequestParam(value = "file", required = false) MultipartFile file) {
        try {
            AnhGiay anhGiay = service.details(id);
            if (anhGiay == null) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("AnhGiay not found");
            }
            if (file != null && !file.isEmpty()) {
                byte[] bytes = file.getBytes();
                Path path = fileStorageLocation.resolve(file.getOriginalFilename());
                Files.write(path, bytes);
                anhGiay.setTenUrl(file.getOriginalFilename());
            }
            anhGiay.setTrangThai(trangThai);
            service.update(id, anhGiay);
            return ResponseEntity.ok("Update thanh cong");
        } catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Update that bai");
        }
    }
}



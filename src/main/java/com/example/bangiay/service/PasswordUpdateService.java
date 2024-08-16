package com.example.bangiay.service;

import com.example.bangiay.entity.KhachHang;
import com.example.bangiay.entity.NhanVien;
import com.example.bangiay.repository.KhachHangRepository;
import com.example.bangiay.repository.NhanVienRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PasswordUpdateService {
    @Autowired
    private NhanVienRepository nhanVienRepository;
    @Autowired
    private KhachHangRepository khachHangRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    public void updatePassword(){
        List<NhanVien> nhanViens= nhanVienRepository.findAll();
        for (NhanVien nhanVien : nhanViens){
            if(!nhanVien.getMatKhau().startsWith("$2a$")){
                nhanVien.setMatKhau(passwordEncoder.encode(nhanVien.getMatKhau()));
                nhanVienRepository.save(nhanVien);
            }
        }
        List<KhachHang> khachHangs= khachHangRepository.findAll();
        for(KhachHang khachHang : khachHangs){
            if(!khachHang.getMatKhau().startsWith("$2a$")){
                khachHang.setMatKhau(passwordEncoder.encode(khachHang.getMatKhau()));
                khachHangRepository.save(khachHang);
            }
        }
    }
}

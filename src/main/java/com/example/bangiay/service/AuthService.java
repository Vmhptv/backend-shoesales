package com.example.bangiay.service;

import com.example.bangiay.dto.request.LoginRequest;
import com.example.bangiay.dto.request.SignupRequest;
import org.springframework.http.ResponseEntity;

public interface AuthService {
    ResponseEntity<?> login(LoginRequest loginRequest);
    ResponseEntity<?> registerNhanVien(SignupRequest signupRequest);
    ResponseEntity<?> registerKhachHang(SignupRequest signupRequest);
}

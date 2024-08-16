package com.example.bangiay.service.implement;

import com.example.bangiay.entity.KhachHang;
import com.example.bangiay.entity.NhanVien;
import com.example.bangiay.repository.KhachHangRepository;
import com.example.bangiay.repository.NhanVienRepository;
import com.example.bangiay.securirty.CustomUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailServiceImpl implements UserDetailsService {
    @Autowired
    private NhanVienRepository nhanVienRepository;
    @Autowired
    private KhachHangRepository khachHangRepository;
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        NhanVien nhanVien = nhanVienRepository.findByEmail(email);
        if(nhanVien != null){
            return CustomUserDetails.build(nhanVien);
        }
        KhachHang khachHang = khachHangRepository.findByEmail(email);
        if(khachHang != null){
            return CustomUserDetails.build(khachHang);
        }
        throw  new UsernameNotFoundException("User not found with email : "+email);
    }
}

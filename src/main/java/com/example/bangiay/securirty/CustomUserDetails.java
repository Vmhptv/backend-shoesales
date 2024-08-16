package com.example.bangiay.securirty;


import com.example.bangiay.entity.KhachHang;
import com.example.bangiay.entity.NhanVien;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.*;

@Data
@NoArgsConstructor

public class CustomUserDetails implements UserDetails {
    private UUID id;
    private String email;
    private String password;
    private String hoTen;
    private Collection<? extends GrantedAuthority> authorities;

    public CustomUserDetails(UUID id, String email, String password, String hoTen,Collection<? extends GrantedAuthority> authorities) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.hoTen = hoTen;
        this.authorities = authorities;
    }
    public static CustomUserDetails build(NhanVien nhanVien) {
        List<GrantedAuthority> authorities = new ArrayList<>();

        if (nhanVien.getChucVu() != null) {
            String chucVuMa = nhanVien.getChucVu().getMa();
            String role = "";

            if (chucVuMa.startsWith("QL")) {
                role = "ROLE_QUAN_LY";
            } else if (chucVuMa.startsWith("NV")) {
                role = "ROLE_NHAN_VIEN";
            }

            if (!role.isEmpty()) {
                authorities.add(new SimpleGrantedAuthority(role));
            }
        }

        return new CustomUserDetails(
                nhanVien.getId(),
                nhanVien.getEmail(),
                nhanVien.getMatKhau(),
                nhanVien.getHoTen(),
                authorities);
    }

    public static CustomUserDetails build(KhachHang khachHang) {
        List<GrantedAuthority> authorities = Collections.singletonList(new SimpleGrantedAuthority("ROLE_KHACH_HANG"));

        return new CustomUserDetails(
                khachHang.getId(),
                khachHang.getEmail(),
                khachHang.getMatKhau(),
                khachHang.getHoTen(),
                authorities);
    }
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
    }

    public String getHoTen() {
        return hoTen;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}

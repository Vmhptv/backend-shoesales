package com.example.bangiay.dto.request;

import lombok.*;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SignupRequest {
    private String email;
    private String matKhau;
    private String hoTen;
    private String soDienThoai;
}

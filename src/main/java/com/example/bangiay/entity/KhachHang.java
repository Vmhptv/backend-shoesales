package com.example.bangiay.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;
import java.util.UUID;

@Table(name = "KHACH_HANG")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder

public class KhachHang {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private UUID id;

    @Column(name = "MA")
    private String ma;

    @Column(name = "ANH")
    private String anh;

    @Column(name = "HO_TEN")
    private String hoTen;

    @Column(name = "NGAY_SINH")
    private Date ngaySinh;

    @Column(name = "SO_DIEN_THOAI")
    private String soDienThoai;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "MAT_KHAU")
    private String matKhau;

    @Column(name = "TRANG_THAI")
    private int trangThai;

    @ManyToOne
    @JoinColumn(name = "ID_HANG_KHACH_HANG")
    private HangKhachHang hangKhachHang;
}

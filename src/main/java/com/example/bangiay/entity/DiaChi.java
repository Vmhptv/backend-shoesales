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

import java.util.UUID;

@Table(name = "DIA_CHI")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder

public class DiaChi {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private UUID id;

    @Column(name = "MA")
    private String ma;

    @Column(name = "TEN_DIA_CHI")
    private String tenDiaChi;

    @Column(name = "TEN_NGUOI_NHAN")
    private String tenNguoiNhan;

    @Column(name = "SO_DIEN_THOAI_NGUOI_NHAN")
    private String sdtNguoiNhan;

    @Column(name = "XA")
    private String xa;

    @Column(name = "HUYEN")
    private String huyen;

    @Column(name = "THANH_PHO")
    private String thanhPho;

    @Column(name = "TRANG_THAI")
    private int trangThai;

    @ManyToOne
    @JoinColumn(name = "ID_KHACH_HANG")
    private KhachHang khachHang;
}

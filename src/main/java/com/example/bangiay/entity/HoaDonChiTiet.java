package com.example.bangiay.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.UUID;

@Table(name = "HOA_DON_CHI_TIET")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder

public class HoaDonChiTiet {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private UUID id;

    @Column(name = "SO_LUONG")
    private int soLuong;

    @Column(name = "GIA_NHAP")
    private BigDecimal giaNhap;

    @Column(name = "DON_GIA")
    private BigDecimal donGia;

    @Column(name = "TRANG_THAI")
    private int trangThai;

    @ManyToOne
    @JoinColumn(name = "ID_HOA_DON")
    @JsonIgnore
    private HoaDon hoaDon;

    @ManyToOne
    @JoinColumn(name = "ID_GIAY_CHI_TIET")
    private GiayChiTiet giayChiTiet;
}

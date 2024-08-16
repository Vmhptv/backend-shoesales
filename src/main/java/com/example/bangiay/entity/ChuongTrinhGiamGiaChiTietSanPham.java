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

import java.math.BigDecimal;
import java.util.Date;
import java.util.UUID;

@Table(name = "CHUONG_TRINH_GIAM_GIA_CHI_TIET_SAN_PHAM")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder

public class ChuongTrinhGiamGiaChiTietSanPham {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private UUID id;

    @Column(name = "SO_TIEN_DA_GIAM")
    private BigDecimal soTienDaGiam;

    @Column(name = "TRANG_THAI")
    private int trangThai;

    @ManyToOne
    @JoinColumn(name = "ID_GIAY")
    private Giay giay;

    @ManyToOne
    @JoinColumn(name = "ID_CHUONG_TRINH_GIAM_GIA_SAN_PHAM")
    private ChuongTrinhGiamGiaSanPham ctggsp;

}

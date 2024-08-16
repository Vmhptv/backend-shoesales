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

@Table(name = "CHUONG_TRINH_GIAM_GIA_HOA_DON")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder

public class ChuongTrinhGiamGiaHoaDon {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private UUID id;

    @Column(name = "MA")
    private String ma;

    @Column(name = "TEN")
    private String ten;

    @Column(name = "DIEU_KIEN")
    private BigDecimal dieuKien;

    @Column(name = "SO_TIEN_GIAM_MAX")
    private BigDecimal soTienGiamMax;

    @Column(name = "NGAY_BAT_DAU")
    private Date ngayBatDau;

    @Column(name = "NGAY_KET_THUC")
    private Date ngayKetThuc;

    @Column(name = "PHAN_TRAM_GIAM")
    private int phanTramGiam;

    @Column(name = "SO_LUONG")
    private int soLuong;

    @Column(name = "TRANG_THAI")
    private int trangThai;
}

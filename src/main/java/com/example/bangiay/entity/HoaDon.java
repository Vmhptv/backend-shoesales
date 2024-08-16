package com.example.bangiay.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Table(name = "HOA_DON")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder

public class HoaDon {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private UUID id;

    @Column(name = "MA")
    private String ma;

    @Column(name = "NGAY_TAO")
    private Date ngayTao;

    @Column(name = "NGAY_THANH_TOAN")
    private Date ngayThanhToan;

    @Column(name = "MO_TA")
    private String moTa;

    @Column(name = "TEN_NGUOI_NHAN")
    private String tenNguoiNhan;

    @Column(name = "SO_DIEN_THOAI_NGUOI_NHAN")
    private String sdtNguoiNhan;

    @Column(name = "DIA_CHI")
    private String diaChi;

    @Column(name = "TONG_TIEN")
    private BigDecimal tongTien;

    @Column(name = "HINH_THUC_MUA")
    private int hinhThucMua;

    @Column(name = "HINH_THUC_THANH_TOAN")
    private int hinhThucThanhToan;

    @Column(name = "HINH_THUC_NHAN_HANG")
    private int hinhThucNhanHang;

    @Column(name = "SO_TIEN_GIAM")
    private BigDecimal soTienGiam;

    @Column(name = "PHI_SHIP")
    private BigDecimal phiShip;

    @Column(name = "SO_DIEM_SU_DUNG")
    private int soDiemSuDung;

    @Column(name = "SO_TIEN_QUY_DOI")
    private BigDecimal soTienQuyDoi;

    @Column(name = "TRANG_THAI")
    private int trangThai;

    @ManyToOne
    @JoinColumn(name = "ID_NHAN_VIEN")
    private NhanVien nhanVien;

    @ManyToOne
    @JoinColumn(name = "ID_KHACH_HANG")
    private KhachHang khachHang;
    @OneToMany(mappedBy = "hoaDon", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<HoaDonChiTiet> items;
}

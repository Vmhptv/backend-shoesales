package com.example.bangiay.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;
import java.util.UUID;

@Table(name = "GIAY")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder

public class Giay {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private UUID id;

    @Column(name = "MA")
    private String ma;

    @Column(name = "TEN")
    private String ten;

    @Column(name = "MO_TA")
    private String moTa;

    @Column(name = "GIA_NHAP")
    private BigDecimal giaNhap;

    @Column(name = "GIA_BAN")
    private BigDecimal giaBan;

    @Column(name = "GIA_SAU_KHUYEN_MAI")
    private BigDecimal giaSauKhuyenMai;

    @Column(name = "DO_HOT")
    private int doHot;

    @Column(name = "TRANG_THAI")
    private int trangThai;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ID_THUONG_HIEU")
    private ThuongHieu thuongHieu;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ID_CHAT_LIEU")
    private ChatLieu chatLieu;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ID_DE_GIAY")
    private DeGiay deGiay;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ID_XUAT_XU")
    private XuatXu xuatXu;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ID_KIEU_DANG")
    private KieuDang kieuDang;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ID_MAU_SAC")
    private MauSac mauSac;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ID_ANH_GIAY")
    private AnhGiay anhGiay;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ID_KICH_CO")
    private KichCo kichCo;
}

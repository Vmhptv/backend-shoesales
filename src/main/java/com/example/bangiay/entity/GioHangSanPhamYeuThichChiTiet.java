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

@Table(name = "GIO_HANG_SAN_PHAM_YEU_THICH_CHI_TIET")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder

public class GioHangSanPhamYeuThichChiTiet {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private UUID id;

    @Column(name = "NGAY_TAO")
    private Date ngayTao;

    @Column(name = "TRANG_THAI")
    private int trangThai;

    @ManyToOne
    @JoinColumn(name = "ID_GIO_HANG_SAN_PHAM_YEU_THICH")
    private GioHangSanPhamYeuThich ghspyt;

    @ManyToOne
    @JoinColumn(name = "ID_GIAY")
    private Giay giay;
}

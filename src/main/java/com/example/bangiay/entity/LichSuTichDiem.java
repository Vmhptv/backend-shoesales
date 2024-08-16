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

@Table(name = "LICH_SU_TICH_DIEM")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder

public class LichSuTichDiem {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private UUID id;

    @Column(name = "SO_DIEM_DA_DUNG")
    private int soDiemDaDung;

    @Column(name = "NGAY_SU_DUNG")
    private Date ngaySuDung;

    @Column(name = "SO_DIEM_CONG")
    private int soDiemCong;

    @Column(name = "TRANG_THAI")
    private int trangThai;

    @ManyToOne
    @JoinColumn(name = "ID_VI_DIEM")
    private ViDiem viDiem;

    @ManyToOne
    @JoinColumn(name = "ID_HOA_DON")
    private HoaDon hoaDon;

    @ManyToOne
    @JoinColumn(name = "ID_QUY_DOI_DIEM")
    private QuyDoiDiem quyDoiDiem;
}

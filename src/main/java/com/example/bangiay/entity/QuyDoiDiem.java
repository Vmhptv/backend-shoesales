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
import java.util.UUID;

@Table(name = "QUY_DOI_DIEM")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder

public class QuyDoiDiem {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private UUID id;

    @Column(name = "SO_TIEN_TUONG_UNG")
    private BigDecimal soTienTuongUng;

    @Column(name = "SO_DIEM_TUONG_UNG")
    private int soDiemTuongUng;

    @Column(name = "TRANG_THAI")
    private int trangThai;
}

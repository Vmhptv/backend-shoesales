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

@Table(name = "NHAN_VIEN")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder

public class NhanVien {
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

    @Column(name = "DIA_CHI")
    private String diaChi;

    @Column(name = "XA")
    private String xa;

    @Column(name = "HUYEN")
    private String huyen;

    @Column(name = "THANH_PHO")
    private String thanhPho;

    @Column(name = "SO_DIEN_THOAI")
    private String soDienThoai;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "MAT_KHAU")
    private String matKhau;

    @Column(name = "NGAY_VAO_LAM")
    private Date ngayVaoLam;

    @Column(name = "NGAY_NGHI_VIEC")
    private Date ngayNghiViec;

    @Column(name = "TRANG_THAI")
    private int trangThai;

    @ManyToOne
    @JoinColumn(name = "ID_CHUC_VU")
    private ChucVu chucVu;
}

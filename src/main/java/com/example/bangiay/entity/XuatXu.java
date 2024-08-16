package com.example.bangiay.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.UUID;

@Table(name = "XUAT_XU")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder

public class XuatXu {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private UUID id;

    @Column(name = "MA")
    private String ma;


    @Column(name = "TEN")
    private String ten;

    @Column(name = "TRANG_THAI")
    private int trangThai;

    public XuatXu(String ten) {
        this.ten = ten;
    }
    public static XuatXu fromString(String ten) {
        return new XuatXu(ten);
    }
}

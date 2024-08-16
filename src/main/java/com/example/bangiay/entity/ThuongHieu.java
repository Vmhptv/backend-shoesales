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

@Table(name = "THUONG_HIEU")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder

public class ThuongHieu {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private UUID id;

    @Column(name = "TEN_URL", nullable = false, unique = true)
    private String tenUrl;

    @Column(name = "MA" , nullable = false, unique = true)
    private String ma;

    @Column(name = "TEN" , nullable = false, unique = true)
    private String ten;

    @Column(name = "TRANG_THAI")
    private int trangThai;

    public ThuongHieu(String ten) {
        this.ten = ten;
    }
    public static ThuongHieu fromString(String ten) {
        return new ThuongHieu(ten);
    }
}

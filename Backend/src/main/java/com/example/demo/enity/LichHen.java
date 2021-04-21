package com.example.demo.enity;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
public class LichHen {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long maLichHen;
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    private Date thoiGian;
    @Column(name = "TrieuChung")
    private String trieuChung;
    @Column(name = "GhiChu")
    private String ghiChu;
    ////
    @ManyToOne
    @JoinColumn
    private BenhNhan benhnhan;

    @OneToOne
    private NhanVien nhanVien;

    public Long getMaLichHen() {
        return maLichHen;
    }

    public void setMaLichHen(Long maLichHen) {
        this.maLichHen = maLichHen;
    }

    public Date getThoiGian() {
        return thoiGian;
    }

    public void setThoiGian(Date thoiGian) {
        this.thoiGian = thoiGian;
    }

    public String getTrieuChung() {
        return trieuChung;
    }

    public void setTrieuChung(String trieuChung) {
        this.trieuChung = trieuChung;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }

    public BenhNhan getBenhNhan() {
        return benhnhan;
    }

    public void setBenhNhan(BenhNhan benhNhan) {
        this.benhnhan = benhNhan;
    }

    public NhanVien getNhanVien() {
        return nhanVien;
    }

    public void setNhanVien(NhanVien nhanVien) {
        this.nhanVien = nhanVien;
    }

    public LichHen() {
    }
}

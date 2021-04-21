package com.example.demo.enity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
public class ChiTietDonThuoc {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne
    @NotNull
    private Thuoc thuoc;
    @NotNull
    private int soLuong;
    @NotNull
    private String ghiChu;
    @NotNull
    private Float giaTien;
    @NotNull
    @ManyToOne
    @JoinColumn
    private DonThuoc donthuoc;
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Thuoc getThuoc() {
        return thuoc;
    }

    public void setThuoc(Thuoc thuoc) {
        this.thuoc = thuoc;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public Float getGiaTien() {
        return giaTien;
    }

    public void setGiaTien(Float giaTien) {
        this.giaTien = giaTien;
    }

    public DonThuoc getDonthuoc() {
        return donthuoc;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }

    public void setDonthuoc(DonThuoc donthuoc) {
        this.donthuoc = donthuoc;
    }

    public ChiTietDonThuoc() {
    }
}

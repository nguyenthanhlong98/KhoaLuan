package com.example.demo.enity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class LichKhamBenh {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date ngayLap;
    @OneToOne
    private NhanVien nhanvien;
    @OneToMany(fetch = FetchType.LAZY,mappedBy = "lichkhambenh")
    @JsonIgnore
    private List<BenhNhan>dsbenhnhan;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getNgayLap() {
        return ngayLap;
    }

    public void setNgayLap(Date ngayLap) {
        this.ngayLap = ngayLap;
    }

    public NhanVien getNhanvien() {
        return nhanvien;
    }

    public void setNhanvien(NhanVien nhanvien) {
        this.nhanvien = nhanvien;
    }

    public List<BenhNhan> getDsbenhnhan() {
        return dsbenhnhan;
    }

    public void setDsbenhnhan(List<BenhNhan> dsbenhnhan) {
        this.dsbenhnhan = dsbenhnhan;
    }

    public LichKhamBenh() {
    }
}

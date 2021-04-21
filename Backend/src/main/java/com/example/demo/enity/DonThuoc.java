package com.example.demo.enity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class DonThuoc {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@OneToMany(fetch = FetchType.LAZY,mappedBy = "donthuoc")
	@JsonIgnore
	private List<ChiTietDonThuoc> dsChiTietDonThuoc;

	@OneToOne
	@MapsId
	private PhieuKhambenh phieukhambenh;
	@NotNull
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	private Date ngayLapDon;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}


	public List<ChiTietDonThuoc> getDsChiTietDonThuoc() {
		return dsChiTietDonThuoc;
	}

	public void setDsChiTietDonThuoc(List<ChiTietDonThuoc> dsChiTietDonThuoc) {
		this.dsChiTietDonThuoc = dsChiTietDonThuoc;
	}

	public PhieuKhambenh getPhieukhambenh() {
		return phieukhambenh;
	}

	public void setPhieukhambenh(PhieuKhambenh phieukhambenh) {
		this.phieukhambenh = phieukhambenh;
	}

	public Date getNgayLapDon() {
		return ngayLapDon;
	}

	public void setNgayLapDon(Date ngayLapDon) {
		this.ngayLapDon = ngayLapDon;
	}

	public DonThuoc() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}

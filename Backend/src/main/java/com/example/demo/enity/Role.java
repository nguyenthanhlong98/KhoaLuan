package com.example.demo.enity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
public class Role {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String name;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@OneToMany(fetch = FetchType.LAZY,mappedBy = "role")
	@JsonIgnore
	public List<TaiKhoan> dstaikhoan;

	public List<TaiKhoan> getDstaikhoan() {
		return dstaikhoan;
	}

	public void setDstaikhoan(List<TaiKhoan> dstaikhoan) {
		this.dstaikhoan = dstaikhoan;
	}

	public Role() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}

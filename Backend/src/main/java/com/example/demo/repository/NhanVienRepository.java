package com.example.demo.repository;

import com.example.demo.enity.BenhNhan;
import com.example.demo.enity.NhanVien;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NhanVienRepository extends JpaRepository<NhanVien,Long> {
    @Query(value = "select * from nhan_vien where ten like %?1%",nativeQuery = true)
    List<NhanVien> findByName(String ten);

    @Query(value = "select * from nhan_vien where so_dien_thoai like %?1%",nativeQuery = true)
    List<NhanVien> findBySDT(String sdt);

    @Query(value = "select * from nhan_vien where cmnd like %?1%",nativeQuery = true)
    List<NhanVien> findByCMND(String cmnd);

    @Query(value = "select * from nhan_vien where tai_khoan_username like ?1",nativeQuery = true)
    NhanVien findByUser(String username);
}

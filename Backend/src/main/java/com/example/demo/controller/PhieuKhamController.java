package com.example.demo.controller;

import com.example.demo.enity.PhieuKhambenh;
import com.example.demo.repository.PhieuKhamRepository;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/phieukham")
public class PhieuKhamController {

    @Autowired
    PhieuKhamRepository phieuKhamRepository;

    @GetMapping("/getall")
    public List<PhieuKhambenh> GetAll(){
        return phieuKhamRepository.findAll();
    }

    @GetMapping("/getone/{id}")
    public ResponseEntity<PhieuKhambenh> getById(@PathVariable(value = "id") Long id)
            throws ResourceNotFoundException {
        PhieuKhambenh phieuKhambenh = phieuKhamRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + id));
        return ResponseEntity.ok().body(phieuKhambenh);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<PhieuKhambenh> update(@PathVariable(value = "id") Long id,
                                                    @RequestBody PhieuKhambenh phieukhambenhdetail) throws ResourceNotFoundException {
        PhieuKhambenh phieuKhambenh =phieuKhamRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("nguoidung not found for this id :: " + id));
        phieuKhambenh.setNgayLapPhieu(phieuKhambenh.getNgayLapPhieu());
        phieuKhambenh.setChanDoan(phieukhambenhdetail.getChanDoan());
        phieuKhambenh.setNhanvien(phieukhambenhdetail.getNhanvien());
        phieuKhambenh.setBenhnhan(phieukhambenhdetail.getBenhnhan());
        phieuKhambenh.setDonthuoc(phieukhambenhdetail.getDonthuoc());
        phieuKhambenh.setTienKham(phieukhambenhdetail.getTienKham());
        phieuKhambenh.setTrieuChung(phieukhambenhdetail.getTrieuChung());
        phieuKhambenh.setTrangThai(phieukhambenhdetail.isTrangThai());
        phieuKhambenh.setDsphieudichvu(phieukhambenhdetail.getDsphieudichvu());
        final PhieuKhambenh updated = phieuKhamRepository.save(phieuKhambenh);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/delete/{id}")
    public Map<String, Boolean> delete(@PathVariable(value = "id") Long id)
            throws ResourceNotFoundException {
        PhieuKhambenh phieuKhambenh = phieuKhamRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Nguoi dung not found for this id :: " + id));

        phieuKhamRepository.delete(phieuKhambenh);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }

    @PostMapping("/insert")
    public PhieuKhambenh them( @RequestBody PhieuKhambenh phieuKhambenh) {
        return phieuKhamRepository.save(phieuKhambenh);
    }

}

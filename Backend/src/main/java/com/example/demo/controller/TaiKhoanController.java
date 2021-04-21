package com.example.demo.controller;

import com.example.demo.enity.TaiKhoan;
import com.example.demo.repository.TaiKhoantRepository;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/taikhoan")
public class TaiKhoanController {

    @Autowired
    TaiKhoantRepository taiKhoantRepository;

    @GetMapping("/getall")
    public List<TaiKhoan> getAllEmployees() {
        return taiKhoantRepository.findAll();
    }

    @GetMapping("/getone/{id}")
    public ResponseEntity<TaiKhoan> getTaiKhoanById(@PathVariable(value = "id") String id)
            throws ResourceNotFoundException {
        TaiKhoan taiKhoan = taiKhoantRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Tai khoan not found for this id :: " + id));
        return ResponseEntity.ok().body(taiKhoan);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<TaiKhoan> updateTaiKhoan(@PathVariable(value = "id") String id,
                                                   @RequestBody TaiKhoan taiKhoanDetais) throws ResourceNotFoundException {
        TaiKhoan taiKhoan = taiKhoantRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Tai khoan not found for this id :: " + id));

        taiKhoan.setUsername(taiKhoanDetais.getUsername());
        taiKhoan.setPassword(taiKhoanDetais.getPassword());
        taiKhoan.setRole(taiKhoanDetais.getRole());
        final TaiKhoan updatedTaiKhoan = taiKhoantRepository.save(taiKhoan);
        return ResponseEntity.ok(updatedTaiKhoan);
    }

    @DeleteMapping("/delete/{id}")
    public Map<String, Boolean> deleteTaiKhoan(@PathVariable(value = "id") String id)
            throws ResourceNotFoundException {
        TaiKhoan taiKhoan = taiKhoantRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Tai khoan not found for this id :: " + id));

        taiKhoantRepository.delete(taiKhoan);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }

    @PostMapping("/insert")
    public TaiKhoan createTaiKhoan(@RequestBody TaiKhoan taiKhoan) {
        return taiKhoantRepository.save(taiKhoan);
    }

}

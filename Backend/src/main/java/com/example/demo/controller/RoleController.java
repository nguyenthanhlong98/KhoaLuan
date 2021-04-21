package com.example.demo.controller;

import com.example.demo.enity.NhanVien;
import com.example.demo.enity.Role;
import com.example.demo.enity.TaiKhoan;
import com.example.demo.repository.RoleRepository;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/role")
public class RoleController {
    @Autowired
    RoleRepository roleRepository;

    @GetMapping("/getone/{id}")
    public ResponseEntity<Role> getById(@PathVariable(value = "id") Long id)
            throws ResourceNotFoundException {
        Role role = roleRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Role not found for this id :: " + id));
        return ResponseEntity.ok().body(role);
    }
    @GetMapping("/getall")
    public List<Role> getAllEmployees() {
        return roleRepository.findAll();
    }
}

package com.example.demo.controller;

import com.example.demo.enity.LichHen;
import com.example.demo.repository.LichHenRepository;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/lichhen")
public class LichHenController {
    @Autowired
    private LichHenRepository lichHenRepository;
    @PostMapping("/insert")
    public LichHen them(@RequestBody LichHen lichHen) {
        return lichHenRepository.save(lichHen);
    }

    @GetMapping("/getall")
    public List<LichHen> GetAll(){
        return lichHenRepository.findAll();
    }

    @GetMapping("/getone/{id}")
    public ResponseEntity<LichHen> getById(@PathVariable(value = "id") Long id)
            throws ResourceNotFoundException {
        LichHen lichHen = lichHenRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Lich hen not found for this id :: " + id));
        return ResponseEntity.ok().body(lichHen);
    }

}

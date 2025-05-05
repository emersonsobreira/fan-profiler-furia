package com.furia.fanprofiler.controllers;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.furia.fanprofiler.dtos.FanRequestDTO;
import com.furia.fanprofiler.models.Fan;
import com.furia.fanprofiler.services.FanService;

@RestController
@RequestMapping("/fans")
public class FanController {

    @Autowired
    private FanService fanService;

    @GetMapping("/{id}")
    public ResponseEntity<Fan> getFanById(@PathVariable UUID id) {
        return fanService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    public ResponseEntity<Fan> updateFan(@PathVariable UUID id, @RequestBody FanRequestDTO dto) {
        Fan updatedFan = fanService.updateFan(id, dto);
        return ResponseEntity.ok(updatedFan);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFan(@PathVariable UUID id) {
        fanService.deleteFan(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping
    public ResponseEntity<Fan> createFan(@RequestBody FanRequestDTO dto) {
        Fan createdFan = fanService.createFan(dto);
        return ResponseEntity.status(201).body(createdFan);
    }

    @GetMapping
    public List<Fan> getAllFans() {
        return fanService.getAllFans();
    }
}

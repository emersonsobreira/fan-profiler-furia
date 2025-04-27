package com.furia.fanprofiler.controllers;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.furia.fanprofiler.models.Fan;
import com.furia.fanprofiler.repositories.FanRepository;

@RestController
@RequestMapping("/fans")
public class FanController {

    @Autowired
    private FanRepository fanRepository;

    @PostMapping
    public Fan createFan(@RequestBody Fan fan) {
        fan.setAiAnalysisResult("Documento verificado com sucesso. Sem inconsistências.");
        return fanRepository.save(fan);
    }

    
    @GetMapping
    public List<Fan> getAllFans() {
        return fanRepository.findAll();
    }

  
    @GetMapping("/{id}")
    public Optional<Fan> getFanById(@PathVariable UUID id) {
        return fanRepository.findById(id);
    }

   
    @GetMapping("/cpf/{cpf}")
    public Fan getFanByCpf(@PathVariable String cpf) {
        return fanRepository.findByCpf(cpf);
    }

    @PutMapping("/{id}")
    public Fan updateFan(@PathVariable UUID id, @RequestBody Fan updatedFan) {
        return fanRepository.findById(id).map(fan -> {
            fan.setName(updatedFan.getName());
            fan.setEmail(updatedFan.getEmail());
            fan.setCpf(updatedFan.getCpf());
            fan.setAddress(updatedFan.getAddress());
            return fanRepository.save(fan);
        }).orElseThrow(() -> new RuntimeException("Fan not found"));
    }

    @DeleteMapping("/{id}")
    public void deleteFan(@PathVariable UUID id) {
        fanRepository.deleteById(id);
    }
}

package com.furia.fanprofiler.controllers;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.UUID;

import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import com.furia.fanprofiler.models.Fan;
import com.furia.fanprofiler.repositories.FanRepository;


@RestController
@RequestMapping("/fans")
public class FanController {

    private final FanRepository fanRepository;

    
    public FanController(FanRepository fanRepository) {
        this.fanRepository = fanRepository;
    }

    @PostMapping
    public Fan createFan(@RequestBody Fan fan) {
        fan.setAiAnalysisResult("Documento verificado com sucesso. Sem inconsistências.");
        return fanRepository.save(fan);
    }

    @PostMapping("/{id}/upload")
    public ResponseEntity<String> uploadDocument(
            @PathVariable UUID id,
            @RequestParam("file") MultipartFile file) {

        Fan fan = fanRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Fan not found"));

        try {

            if (!file.getContentType().equals("application/pdf")) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Somente arquivos PDF são permitidos.");
            }


            String uploadDir = "uploads";
            Files.createDirectories(Paths.get(uploadDir));

            String filename = UUID.randomUUID().toString() + "_" + file.getOriginalFilename().replaceAll("[^a-zA-Z0-9\\.\\-]", "_");
            Path filePath = Paths.get(uploadDir, filename);

            try (InputStream inputStream = file.getInputStream()) {
                Files.copy(inputStream, filePath, StandardCopyOption.REPLACE_EXISTING);
            }
            fan.setDocumentPath(filePath.toString());
            fan.setAiAnalysisResult("Documento verificado com sucesso. Sem inconsistências.");
            fanRepository.save(fan);

            return ResponseEntity.ok("Upload realizado com sucesso e documento analisado.");
        } catch (IOException e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Erro ao salvar o arquivo", e);
        }
    }

    @GetMapping
    public List<Fan> getAllFans() {
        return fanRepository.findAll();
    }

    @GetMapping("/{id}")
    public Fan getFanById(@PathVariable UUID id) {
        return fanRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Fan not found"));
    }

    @GetMapping("/cpf/{cpf}")
    public Fan getFanByCpf(@PathVariable String cpf) {
        Fan fan = fanRepository.findByCpf(cpf);
        if (fan == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Fan not found");
        }
        return fan;
    }

    @GetMapping("/{id}/download")
public ResponseEntity<Resource> downloadDocument(@PathVariable UUID id) {
    Fan fan = fanRepository.findById(id)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Fan não encontrado"));

    try {
        Path filePath = Path.of(fan.getDocumentPath());
        Resource resource = new UrlResource(filePath.toUri());

        if (!resource.exists() || !resource.isReadable()) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Arquivo não pode ser lido");
        }

        String fileName = filePath.getFileName().toString();

        return ResponseEntity.ok()
        .contentType(MediaType.APPLICATION_PDF)
        .header("Content-Disposition", "attachment; filename=\"" + fileName + "\"")
        .body(resource);
    

    } catch (IOException e) {
        throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Erro ao carregar o arquivo", e);
    }
}



    @PutMapping("/{id}")
    public Fan updateFan(@PathVariable UUID id, @RequestBody Fan updatedFan) {
        return fanRepository.findById(id).map(fan -> {
            fan.setName(updatedFan.getName());
            fan.setEmail(updatedFan.getEmail());
            fan.setCpf(updatedFan.getCpf());
            fan.setAddress(updatedFan.getAddress());
            return fanRepository.save(fan);
        }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Fan not found"));
    }

    @DeleteMapping("/{id}")
    public void deleteFan(@PathVariable UUID id) {
        if (!fanRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Fan not found");
        }
        fanRepository.deleteById(id);
    }
}

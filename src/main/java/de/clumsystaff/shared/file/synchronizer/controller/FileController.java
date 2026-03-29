package de.clumsystaff.shared.file.synchronizer.controller;

import de.clumsystaff.shared.file.synchronizer.service.UploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/files")
public class FileController {

    @Autowired
    private UploadService uploadService;

    @PostMapping
    public ResponseEntity<String> uploadFile(MultipartFile file) throws IOException {

        this.uploadService.uploadFile(file);

        return ResponseEntity.ok().build();
    }
}

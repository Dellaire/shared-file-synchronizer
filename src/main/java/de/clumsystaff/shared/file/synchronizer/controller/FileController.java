package de.clumsystaff.shared.file.synchronizer.controller;

import de.clumsystaff.shared.file.synchronizer.persistence.FileMetadata;
import de.clumsystaff.shared.file.synchronizer.service.UploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/files")
public class FileController {

    @Autowired
    private UploadService uploadService;

    @PostMapping
    public ResponseEntity<String> uploadFile(@RequestPart MultipartFile file, @RequestPart FileMetadata fileMetadata)
            throws Exception {

        this.uploadService.uploadFile(file, fileMetadata.previousHashCode());

        return ResponseEntity.ok().build();
    }

    @GetMapping("/{fileName}")
    public ResponseEntity<InputStreamResource> downloadFile(@PathVariable String fileName) throws Exception {

        return ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_OCTET_STREAM)
                .body(new InputStreamResource(this.uploadService.downloadFile(fileName)));
    }
}

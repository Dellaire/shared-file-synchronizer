package de.clumsystaff.shared.file.synchronizer.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Component
public class UploadService {

    @Value("${shared.file.synchronizer.folder.name}")
    private String directory;

    public void uploadFile(MultipartFile file) throws IOException {

        File dest = new File(directory + file.getOriginalFilename());
        file.transferTo(dest);
    }
}

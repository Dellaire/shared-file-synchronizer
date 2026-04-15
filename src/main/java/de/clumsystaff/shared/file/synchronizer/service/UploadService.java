package de.clumsystaff.shared.file.synchronizer.service;

import de.clumsystaff.shared.file.synchronizer.persistence.FileStorage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.security.MessageDigest;
import java.util.Arrays;

@Component
public class UploadService {

    @Autowired
    private FileStorage fileStorage;

    public void uploadFile(MultipartFile file, byte[] previousHashCode) throws Exception {

        byte[] existingHashCode = this.fileStorage.getLatestHashCode(file.getName());
        if (existingHashCode.length > 0 && !Arrays.equals(previousHashCode, existingHashCode)) {
            throw new RuntimeException("Invalid hash code, file can not be merged!");
        }

        this.fileStorage.saveFile(file, this.calculateHash(file));
    }

    public InputStream downloadFile(String fileName) {

        return this.fileStorage.loadFile(fileName);
    }

    private byte[] calculateHash(MultipartFile file) throws Exception {

        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        return digest.digest(file.getBytes());
    }
}

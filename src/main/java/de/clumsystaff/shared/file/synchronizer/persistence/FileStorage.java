package de.clumsystaff.shared.file.synchronizer.persistence;

import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;

public interface FileStorage {

    void saveFile(MultipartFile file, byte[] hashCode) throws Exception;

    InputStream loadFile(String fileName);

    byte[] getLatestHashCode(String fileName);
}

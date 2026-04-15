package de.clumsystaff.shared.file.synchronizer.persistence;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.InputStream;

@Component
@ConditionalOnProperty(name = "shared.file.synchronizer.repository", havingValue = "harddrive")
public class HardDriveFileStorage implements FileStorage {

    @Value("${shared.file.synchronizer.folder.name}")
    private String directory;

    public HardDriveFileStorage() {
        throw new RuntimeException("Usage of hard drive is not implemented yet.");
    }

    @Override
    public void saveFile(MultipartFile file, byte[] hashCode) throws Exception {

        File dest = new File(this.directory + file.getOriginalFilename());
        file.transferTo(dest);
    }

    @Override
    public InputStream loadFile(String fileName) {
        return null;
    }

    @Override
    public byte[] getLatestHashCode(String fileName) {
        return null;
    }
}

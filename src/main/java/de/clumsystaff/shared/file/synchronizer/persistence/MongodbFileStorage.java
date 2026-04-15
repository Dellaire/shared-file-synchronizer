package de.clumsystaff.shared.file.synchronizer.persistence;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

@Component
@ConditionalOnProperty(name = "shared.file.synchronizer.repository", havingValue = "mongodb")
public class MongodbFileStorage implements FileStorage {

    @Autowired
    private FileRepository fileRepository;

    @Override
    public void saveFile(MultipartFile file, byte[] hashCode) throws Exception {

        this.fileRepository.save(
                new FileEntity()
                        .setName(file.getOriginalFilename())
                        .setContent(file.getBytes())
                        .setHashCode(hashCode));
    }

    @Override
    public InputStream loadFile(String fileName) {

        return new ByteArrayInputStream(this.fileRepository.findByName(fileName)
                .orElseThrow(() -> new RuntimeException("The file with name '%s' does not exist.".formatted(fileName)))
                .getContent());
    }

    @Override
    public byte[] getLatestHashCode(String fileName) {
        return new byte[0];
    }
}

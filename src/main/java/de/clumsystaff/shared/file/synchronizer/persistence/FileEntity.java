package de.clumsystaff.shared.file.synchronizer.persistence;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@TypeAlias("File")
public class FileEntity {

    @Id
    private String name;

    private byte[] content;
    private byte[] hashCode;

    public String getName() {
        return name;
    }

    ;

    public FileEntity setName(String name) {
        this.name = name;
        return this;
    }

    public byte[] getContent() {
        return content;
    }

    public FileEntity setContent(byte[] content) {
        this.content = content;
        return this;
    }

    public byte[] getHashCode() {
        return hashCode;
    }

    public FileEntity setHashCode(byte[] hashCode) {
        this.hashCode = hashCode;
        return this;
    }
}
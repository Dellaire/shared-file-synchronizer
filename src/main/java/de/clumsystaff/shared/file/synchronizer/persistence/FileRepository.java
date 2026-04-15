package de.clumsystaff.shared.file.synchronizer.persistence;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface FileRepository extends MongoRepository<FileEntity, String> {

    Optional<FileEntity> findByName(String name);
}

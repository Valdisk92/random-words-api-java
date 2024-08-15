package org.morkva.randomwordsapi.infrastructure.mongo.repositories;

import org.morkva.randomwordsapi.infrastructure.entities.WordListDocument;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface MongoWorldListRepository extends CrudRepository<WordListDocument, String> {
}

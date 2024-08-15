package org.morkva.randomwordsapi.infrastructure.repositories;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.StreamSupport;
import org.morkva.randomwordsapi.core.model.WordList;
import org.morkva.randomwordsapi.core.ports.outgoing.WordListRepository;
import org.morkva.randomwordsapi.infrastructure.entities.WordListDocument;
import org.morkva.randomwordsapi.infrastructure.mongo.repositories.MongoWorldListRepository;
import org.springframework.stereotype.Component;

@Component
public class MongoWordListRepositoryAdapter implements WordListRepository {

  private final MongoWorldListRepository repository;

  public MongoWordListRepositoryAdapter(MongoWorldListRepository repository) {
    this.repository = repository;
  }

  @Override
  public void save(WordList wordList) {
    repository.save(
        new WordListDocument(wordList.getId().toString(), wordList.getName(), wordList.getWords()));
  }

  @Override
  public Optional<WordList> findById(UUID id) {
    return this.repository
        .findById(id.toString())
        .map(document -> new WordList(document.getUUID(), document.getName(), document.getWords()));
  }

  @Override
  public List<WordList> findAll() {
    Iterable<WordListDocument> all = this.repository.findAll();

    return StreamSupport.stream(all.spliterator(), false)
        .map(document -> new WordList(document.getUUID(), document.getName(), document.getWords()))
        .toList();
  }

  @Override
  public void delete(UUID id) {
    this.repository.deleteById(id.toString());
  }
}

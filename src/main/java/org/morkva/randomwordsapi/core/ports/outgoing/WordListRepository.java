package org.morkva.randomwordsapi.core.ports.outgoing;

import org.morkva.randomwordsapi.core.model.WordList;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface WordListRepository {
  void save(WordList wordList);

  Optional<WordList> findById(UUID id);

  List<WordList> findAll();

  void delete(UUID id);
}

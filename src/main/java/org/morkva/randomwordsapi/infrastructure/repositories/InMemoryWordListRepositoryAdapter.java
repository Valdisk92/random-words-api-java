package org.morkva.randomwordsapi.infrastructure.repositories;

import org.morkva.randomwordsapi.core.model.WordList;
import org.morkva.randomwordsapi.core.ports.outgoing.WordListRepository;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component
public class InMemoryWordListRepositoryAdapter implements WordListRepository {

  private List<WordList> wordLists = new ArrayList<>();

  @Override
  public void save(WordList wordList) {
    if (!wordLists.contains(wordList)) {
      wordLists.add(wordList);
    } else {
      // replace wordlist by id
      wordLists.set(wordLists.indexOf(wordList), wordList);
    }
  }

  @Override
  public Optional<WordList> findById(UUID id) {
    return wordLists.stream().filter(wordList -> wordList.getId().equals(id)).findFirst();
  }

  public List<WordList> findAll() {
    return wordLists;
  }

  @Override
  public void delete(UUID id) {
    boolean removed = this.wordLists.removeIf(wordList -> wordList.getId().equals(id));

    if (!removed) {
      throw new IllegalArgumentException("There is no word list by id: " + id);
    }
  }
}

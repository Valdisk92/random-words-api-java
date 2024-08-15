package org.morkva.randomwordsapi.core.usecases;

import org.morkva.randomwordsapi.core.model.WordList;
import org.morkva.randomwordsapi.core.ports.incoming.AddWordToList;
import org.morkva.randomwordsapi.core.ports.outgoing.WordListRepository;

import java.util.UUID;

public class AddWordToListUseCase implements AddWordToList {

  private final WordListRepository wordListRepository;

  public AddWordToListUseCase(WordListRepository wordListRepository) {
    this.wordListRepository = wordListRepository;
  }

  @Override
  public void addWordToList(UUID listId, String word) {
    WordList wordList =
        this.wordListRepository
            .findById(listId)
            .orElseThrow(() -> new RuntimeException("Word list not found: " + listId));

    wordList.addWord(word);

    this.wordListRepository.save(wordList);
  }
}

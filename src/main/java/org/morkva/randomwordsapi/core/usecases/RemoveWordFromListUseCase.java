package org.morkva.randomwordsapi.core.usecases;

import org.morkva.randomwordsapi.core.model.WordList;
import org.morkva.randomwordsapi.core.ports.incoming.RemoveWordFromList;
import org.morkva.randomwordsapi.core.ports.outgoing.WordListRepository;

import java.util.UUID;

public class RemoveWordFromListUseCase implements RemoveWordFromList {

  private final WordListRepository wordListRepository;

  public RemoveWordFromListUseCase(WordListRepository wordListRepository) {
    this.wordListRepository = wordListRepository;
  }

  @Override
  public void removeWordFromList(UUID listId, String word) {
    WordList wordList = this.wordListRepository.findById(listId)
            .orElseThrow(() -> new RuntimeException("Word list not found: " + listId));

    wordList.removeWord(word);

    this.wordListRepository.save(wordList);
  }
}

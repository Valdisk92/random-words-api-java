package org.morkva.randomwordsapi.core.usecases;

import org.morkva.randomwordsapi.core.model.WordList;
import org.morkva.randomwordsapi.core.ports.incoming.CreateWordList;
import org.morkva.randomwordsapi.core.ports.outgoing.WordListRepository;

public class CreateWordListUseCase implements CreateWordList {

  private final WordListRepository wordListRepository;

  public CreateWordListUseCase(WordListRepository wordListRepository) {
    this.wordListRepository = wordListRepository;
  }

  @Override
  public void create(CreateWordListCommand command) {
    WordList wordList = new WordList(command.name());

    wordListRepository.save(wordList);
  }
}

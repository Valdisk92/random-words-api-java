package org.morkva.randomwordsapi.core.usecases;

import org.morkva.randomwordsapi.core.ports.incoming.DeleteWordList;
import org.morkva.randomwordsapi.core.ports.outgoing.WordListRepository;

import java.util.UUID;

public class DeleteWordListUseCase implements DeleteWordList {

  private final WordListRepository wordListRepository;

  public DeleteWordListUseCase(WordListRepository wordListRepository) {
    this.wordListRepository = wordListRepository;
  }

  @Override
  public void delete(UUID id) {
    this.wordListRepository.delete(id);
  }
}

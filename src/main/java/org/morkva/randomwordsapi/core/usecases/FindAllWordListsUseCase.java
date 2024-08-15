package org.morkva.randomwordsapi.core.usecases;

import org.morkva.randomwordsapi.core.ports.incoming.FindAllWordLists;
import org.morkva.randomwordsapi.core.ports.outgoing.WordListRepository;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class FindAllWordListsUseCase implements FindAllWordLists {

  private final WordListRepository wordListRepository;

  public FindAllWordListsUseCase(WordListRepository wordListRepository) {
    this.wordListRepository = wordListRepository;
  }

  @Override
  public List<WordListDTO> findAll() {
    return wordListRepository.findAll()
            .stream()
            .map(item -> new WordListDTO(item.getId(), item.getName(), item.getWords()))
            .toList();
  }
}

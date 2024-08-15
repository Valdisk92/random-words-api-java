package org.morkva.randomwordsapi.core.ports.incoming;

import java.util.List;
import java.util.Set;
import java.util.UUID;

public interface FindAllWordLists {
  List<WordListDTO> findAll();

  record WordListDTO(UUID id, String name, Set<String> words) {
  }
}

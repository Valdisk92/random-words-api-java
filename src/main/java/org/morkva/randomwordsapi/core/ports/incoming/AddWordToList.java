package org.morkva.randomwordsapi.core.ports.incoming;

import java.util.UUID;

public interface AddWordToList {
  void addWordToList(UUID listId, String word);
}

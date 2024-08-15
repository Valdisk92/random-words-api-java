package org.morkva.randomwordsapi.core.ports.incoming;

import java.util.UUID;

public interface RemoveWordFromList {
  void removeWordFromList(UUID listId, String word);
}

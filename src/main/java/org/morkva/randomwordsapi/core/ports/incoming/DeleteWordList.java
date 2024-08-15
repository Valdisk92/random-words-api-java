package org.morkva.randomwordsapi.core.ports.incoming;

import java.util.UUID;

public interface DeleteWordList {
  void delete(UUID id);
}

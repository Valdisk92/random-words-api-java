package org.morkva.randomwordsapi.core.ports.incoming;

public interface CreateWordList {
  void create(CreateWordListCommand command);

  record CreateWordListCommand(String name) {
  }
}

package org.morkva.randomwordsapi.infrastructure.entities;

import java.util.Set;
import java.util.UUID;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("word_lists")
public class WordListDocument {

  @Id private String id;

  private String name;

  private Set<String> words;

  public WordListDocument(String id, String name, Set<String> words) {
    this.id = id;
    this.name = name;
    this.words = words;
  }

  public String getId() {
    return id;
  }

  public UUID getUUID() {
    return UUID.fromString(id);
  }

  public String getName() {
    return name;
  }

  public Set<String> getWords() {
    return words;
  }
}

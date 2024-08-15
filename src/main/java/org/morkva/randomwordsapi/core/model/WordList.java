package org.morkva.randomwordsapi.core.model;

import java.util.*;

public class WordList {
  private UUID id;
  private String name;
  private Set<String> words;

  public WordList(UUID id, String name, Set<String> words) {
    this.id = id;
    this.name = name;
    this.words = words;
  }

  public WordList(UUID id, String name) {
    this.id = id;
    this.name = name;
  }

  public WordList(String name) {
    this.id = UUID.randomUUID();
    this.name = name;
    this.words = new TreeSet<>();
  }

  public void addWord(String word) {
    if (this.words.contains(word)) {
      throw new IllegalArgumentException("Word " + word + " already exists");
    }

    this.words.add(word);
  }

  public void removeWord(String word) {
    if (!this.words.contains(word)) {
      throw new IllegalArgumentException("Word " + word + " does not exist");
    }

    this.words.remove(word);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    WordList wordList = (WordList) o;
    return getId().equals(wordList.getId());
  }

  @Override
  public int hashCode() {
    return getId().hashCode();
  }

  public UUID getId() {
    return this.id;
  }

  public String getName() {
    return name;
  }

  public Set<String> getWords() {
    return words;
  }
}

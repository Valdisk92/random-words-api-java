package org.morkva.randomwordsapi.application.controllers;

import java.util.List;
import java.util.UUID;
import org.morkva.randomwordsapi.core.ports.incoming.*;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/word-lists")
public class WordListController {

  private final CreateWordList createWordList;
  private final FindAllWordLists findAllWordLists;
  private final AddWordToList addWordToList;
  private final DeleteWordList deleteWordList;
  private final RemoveWordFromList removeWordFromList;

  public WordListController(
      CreateWordList createWordList,
      FindAllWordLists findAllWordLists,
      AddWordToList addWordToList,
      DeleteWordList deleteWordList,
      RemoveWordFromList removeWordFromList) {
    this.createWordList = createWordList;
    this.findAllWordLists = findAllWordLists;
    this.addWordToList = addWordToList;
    this.deleteWordList = deleteWordList;
    this.removeWordFromList = removeWordFromList;
  }

  @GetMapping
  public List<FindAllWordLists.WordListDTO> findAllWordLists() {
    return this.findAllWordLists.findAll();
  }

  @PostMapping
  public void createWordList(@RequestBody CreateWordList.CreateWordListCommand command) {
    this.createWordList.create(command);
  }

  @DeleteMapping("/{list_id}")
  public void deleteWordList(@PathVariable("list_id") UUID listId) {
    this.deleteWordList.delete(listId);
  }

  @PostMapping("/{list_id}/words")
  public void addNewWordToList(
      @PathVariable("list_id") UUID listId, @RequestBody AddWordRequest request) {
    this.addWordToList.addWordToList(listId, request.word());
  }

  @DeleteMapping("/{list_id}/words/{word}")
  public void removeWordFromList(
      @PathVariable("list_id") UUID listId, @PathVariable("word") String word) {
    this.removeWordFromList.removeWordFromList(listId, word);
  }

  public record AddWordRequest(String word) {}
}

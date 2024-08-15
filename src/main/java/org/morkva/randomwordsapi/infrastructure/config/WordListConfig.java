package org.morkva.randomwordsapi.infrastructure.config;

import org.morkva.randomwordsapi.core.ports.incoming.*;
import org.morkva.randomwordsapi.core.ports.outgoing.WordListRepository;
import org.morkva.randomwordsapi.core.usecases.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WordListConfig {

  @Bean
  public CreateWordList createWordList(
      @Qualifier("mongoWordListRepositoryAdapter") WordListRepository wordListRepository) {
    return new CreateWordListUseCase(wordListRepository);
  }

  @Bean
  public FindAllWordLists findAllWordLists(
      @Qualifier("mongoWordListRepositoryAdapter") WordListRepository wordListRepository) {
    return new FindAllWordListsUseCase(wordListRepository);
  }

  @Bean
  public AddWordToList addWordToList(
      @Qualifier("mongoWordListRepositoryAdapter") WordListRepository wordListRepository) {
    return new AddWordToListUseCase(wordListRepository);
  }

  @Bean
  public RemoveWordFromList removeWordFromList(
      @Qualifier("mongoWordListRepositoryAdapter") WordListRepository wordListRepository) {
    return new RemoveWordFromListUseCase(wordListRepository);
  }

  @Bean
  public DeleteWordList deleteWordList(
      @Qualifier("mongoWordListRepositoryAdapter") WordListRepository wordListRepository) {
    return new DeleteWordListUseCase(wordListRepository);
  }
}

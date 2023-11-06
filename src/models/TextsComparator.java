package models;

import java.time.LocalDateTime;

public class TextsComparator {

  private Text textFirst;

  private Text textSecond;

  private LocalDateTime testTime;

  public TextsComparator(Text textFirst, Text textSecond) {
    this.textFirst = textFirst;
    this.textSecond = textSecond;
    this.testTime = LocalDateTime.now().withNano(0);
  }

  public Text getTextFirst() {
    return textFirst;
  }

  public Text getTextSecond() {
    return textSecond;
  }

  public LocalDateTime getTestTime() {
    return testTime;
  }

  public String getCompareResults() {
    String compareResults =
            "Words in '" + getTextFirst().getTextName() + "' is " + getTextFirst().getNumberOfWords() + "\n" +
            "Words in '" + getTextSecond().getTextName() + "' is " + getTextSecond().getNumberOfWords() + "\n" +
            "Top words in '"  + getTextFirst().getTextName() + "' is \n" + getTextFirst().theMostPopularWords() +"\n" +
            "Top words in '"  + getTextSecond().getTextName() + "' is \n" + getTextSecond().theMostPopularWords() + "\n" +
            "Unique word in '"  + getTextFirst().getTextName() + "' = " + getTextFirst().numberOfUniqWords() +"\n" +
            "Unique word in '"  + getTextSecond().getTextName() + "' = " + getTextSecond().numberOfUniqWords() + "\n";

    return compareResults;
  }
}

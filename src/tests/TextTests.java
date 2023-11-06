package tests;

import models.Text;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TextTests {

  @Test
  void getNumberOfWordsPositiveTest() {
    String testData = "This is text, to check if work correct. "
    + "Und auch ein Test auf Deutsch unter Berücksichtigung der Wörter: Straße, Prüfung.";

    Text testText = new Text("Test", testData);

    int numberOfWords = testText.getNumberOfWords();

    assertEquals(20, numberOfWords);
  }

  @Test
  void theMostPopularWordsPositiveTest() {
    String testData = "First first first. first! second second third";

    Text testText = new Text("Test", testData);

    List<String> expectedWords = List.of("first", "second", "third");
    List<String> actualResults = testText.theMostPopularWords();

    assertEquals(expectedWords, actualResults);
  }

  @Test
  void numberOfUniqWordsPositiveTest () {
    String testData = "First first first. first! second second third";

    Text testText = new Text("Test", testData);
    int expectedNumber = 3;
    int actualResult = testText.numberOfUniqWords();

    assertEquals(expectedNumber, actualResult);
  }
}

package models;

import java.util.*;
import java.util.stream.Collectors;

public class Text {

  final private String textName;

  final private String content;

  public Text(String textName, String content) {
    this.content = content;
    this.textName = textName;
  }

  final static int limitOfTopFrequencyWord = 5;

  public String getContent() {
    return content;
  }

  public String getTextName() {
    return textName;
  }

  public int getNumberOfWords() {

    String[] words = getContent().trim().replaceAll("[^a-zA-ZäöüßÄÖÜ]", " ").split("\\s+");

    return words.length;
  }

  public List<String> theMostPopularWords() {

    String[] words = getContent().replaceAll("[^a-zA-ZäöüßÄÖÜ]", " ").split("\\s+");

    Map<String, Integer> wordFrequency = new HashMap<>();
    for (String word : words) {
      word = word.toLowerCase();
      wordFrequency.put(word, wordFrequency.getOrDefault(word, 0) + 1);
    }

    List<Map.Entry<String, Integer>> sortedList = wordFrequency.entrySet()
            .stream()
            .sorted((entry1,entry2) -> entry2.getValue().compareTo(entry1.getValue()))
            .collect(Collectors.toList());

    List<String> result = new ArrayList<>();
    for (Map.Entry<String, Integer> entry : sortedList) {
      result.add(entry.getKey());
      if (result.size() == limitOfTopFrequencyWord) {
        break;
      }
    }

    return result;
  }

  public int numberOfUniqWords() {
    Set<String> uniqueWords = new HashSet<>();

    String[] words = getContent().replaceAll("[^a-zA-ZäöüßÄÖÜ]", " ").split("\\s+");

    for (String word : words) {
      word = word.toLowerCase();
      uniqueWords.add(word);
    }

    return uniqueWords.size();
  }
}

package compareTexts;

import models.Text;
import models.TextsComparator;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class MainMenu {

  final static String pathToTheTale = "C:\\Users\\AIT TR Student\\ResumeAndInterview\\JavaPractice\\Interview_hardSkill_230611\\Interview_230611\\src\\Storage\\Das Märchen - Goethe .txt";
  final static String pathToOldSurehand = "C:\\Users\\AIT TR Student\\ResumeAndInterview\\JavaPractice\\Interview_hardSkill_230611\\Interview_230611\\src\\Storage\\Old Surehand I - Karl May.txt";
  final static String pathResults = "C:\\Users\\AIT TR Student\\ResumeAndInterview\\JavaPractice\\Interview_hardSkill_230611\\Interview_230611\\src\\Storage\\results.txt";

  final static int maxNumberOfSavedTests = 5;

  public static void main(String[] args) {

    Text fairyTail = new Text("Das Märchen - Goethe", readTextFromFile(pathToTheTale));
    Text vinitu = new Text("Old Surehand I - Karl May", readTextFromFile(pathToOldSurehand));

    List<TextsComparator> resultsForSave = new ArrayList<>();

    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    while (true) {
      System.out.println("Menu");
      System.out.println("1. Compare texts");
      System.out.println("2. Close program");
      System.out.println("Please, enter the number 1 or 2");

      try {
        String choice = reader.readLine();

        switch (choice) {
          case "1":
            TextsComparator test = new TextsComparator(fairyTail, vinitu);
            System.out.println("Test results: \n" + test.getCompareResults());
            resultsForSave.add(test);
            break;
          case "2":
            saveResultsToFile(resultsForSave);
            System.out.println("Result was saved to results.txt");
            System.exit(0);

          default:
            System.out.println("Incorrect income data, please, try again");
        }

      } catch (IOException e) {
        e.printStackTrace();
      }
    }
  }

  private static String readTextFromFile(String path) {
    String result;
    StringBuilder sb = new StringBuilder();

    try {
      BufferedReader reader = new BufferedReader(new FileReader(path));
      String line;
      while ((line = reader.readLine()) != null) {
        sb.append(line).append("\n");
      }
      reader.close();
      result = sb.toString();

    } catch (IOException e) {
      e.printStackTrace();
      result = "";
    }

    return result;
  }

  private static void saveResultsToFile(List<TextsComparator> resultsForSave) {
    try (BufferedWriter writer = new BufferedWriter(new FileWriter(pathResults))) {
      int startIndex = Math.max(0, resultsForSave.size() - maxNumberOfSavedTests);
      for (int i = startIndex; i < resultsForSave.size(); i++) {
        writer.write(resultsForSave.get(i).getTestTime() + "\n"
                + resultsForSave.get(i).getCompareResults() + "\n");
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}

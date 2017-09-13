package algorithms.repeat;

import java.util.Arrays;
import java.util.Collections;

/**
 * Created by Fei Hu on 4/12/17.
 */
public class ReverseWordsInAString {
  public String reverseWords(String s) {
    String[] parts = s.trim().split(" ");
    StringBuilder strBuilder = new StringBuilder();
    for (int i = parts.length - 1; i >= 0; i--) {
      if (!parts[i].equals(" ") && !parts[i].equals("")) {
        strBuilder.append(parts[i].trim());
        strBuilder.append(" ");
      }
    }
    return strBuilder.toString().trim();
  }

  public String reverseWords_2(String s) {
    String[] words = s.trim().split(" +");
    Collections.reverse(Arrays.asList(words));
    return String.join(" ", words);
  }

  public static void main(String[] args) {
    String input = "  a  b c ";
    String[] splits = input.split(" ");
    System.out.println(splits[0]);
  }

}

package algorithms.repeat;

/**
 * Created by Fei Hu on 3/28/17.
 */
public class ZigZag6 {

  private static String convert(String s, int numRows) {
    if (s == null || s.length() == 0)  return s;
    int len = s.length();
    char[] ch = s.toCharArray();
    StringBuilder[] str = new StringBuilder[numRows];
    for (int i = 0; i < numRows; i++) str[i] = new StringBuilder();
    int i = 0;
    while (i < len) {
      for (int j = 0; j < numRows && i < len; j++) {
        str[j].append(ch[i++]);
      }
      for (int j = numRows - 2; j > 0  && i < len; j--) {
        str[j].append(ch[i++]);
      }
    }

    String result = "";
    for(StringBuilder r : str) {
      result = result + r.toString();
    }

    return result;
  }

  public static void main(String[] args) {
    String s = "AB";
    int numRows = 1;
    System.out.println(ZigZag6.convert(s, numRows));

  }

}

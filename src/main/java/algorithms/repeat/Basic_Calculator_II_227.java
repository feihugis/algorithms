package algorithms.repeat;

/**
 * Created by Fei Hu on 9/13/17.
 */
public class Basic_Calculator_II_227 {
  public int calculate(String s) {
    if (s == null || s.length() == 0) throw new IllegalArgumentException();

    String[] plus = s.split("\\+");
    if (plus.length >= 2) {
      int result = 0;
      for(String input : plus) {
        result += calculate(input);
      }
      return result;
    }

    String[] minus = s.split("\\-");
    if (minus.length >= 2) {
      int result = 2 * calculate(minus[0]);
      for(String input : minus) {
        result -= calculate(input);
      }
      return result;
    }

    if (s.contains("*") || s.contains("/")) {
      return calculate(evolve(s));
    }


    return Integer.parseInt(s.trim());
  }

  public String evolve(String s) {
    Long input1 = null, input2 = null;
    int index = 0;
    Character opt = null;
    StringBuilder str = new StringBuilder();

    while((input1 == null || input2 == null) && index < s.length())  {
      char c = s.charAt(index++);
      if (c >= '0' && c <= '9') {
        str.append(c);
        continue;
      } else if (c == ' '){
        continue;
      } else {
        opt = opt == null? c : opt;
        if (input1 != null) {
          input2 = Long.parseLong(str.toString().trim());
        }
        input1 = input1 == null? Long.parseLong(str.toString().trim()) : input1;
        str.setLength(0);
      }
    }

    input2 = input2 == null? Long.parseLong(str.toString().trim()) : input2;

    String result = "";
    if (opt == '*') {
      result = String.valueOf(input1 * input2);
    } else if (opt == '/') {
      result = String.valueOf(input1 / input2);
    }

    if (index < s.length()) {
      result = result + s.substring(index - 1);
    }
    System.out.println(result);
    return result;
  }

  public static void main(String[] args) {
    Basic_Calculator_II_227 solution = new Basic_Calculator_II_227();
    String input = "100000000/1/2/3/4/5/6/7/8/9/10";
    System.out.println(solution.calculate(input));
  }

}

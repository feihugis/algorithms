package algorithms.repeat;

/**
 * Created by Fei Hu on 8/16/17.
 */
public class Integer_To_Roman {


  String[][] keys = new String[][] {
    {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"},
    {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"},
    {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"},
    {"", "M", "MM", "MMM"}
  };

  public String intToRoman(int num) {
    if (num < 1 || num > 3999) throw new IllegalArgumentException();

    int m = ( num % 10000 ) / 1000;
    int c = (num % 1000) / 100;
    int x = (num % 100) / 10;
    int i = num % 10;

    return keys[3][m] + keys[2][c] + keys[1][x] + keys[0][i];
  }

}

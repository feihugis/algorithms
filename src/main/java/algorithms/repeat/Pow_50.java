package algorithms.repeat;

import java.util.Arrays;
import java.util.BitSet;

/**
 * Created by Fei Hu on 8/21/17.
 */
public class Pow_50 {

  public double myPow(double x, int n) {
    if (n == 0) return 1.0;
    if (x == 0.0 && n != 0) return 0.0;
    if (n == 1) return x;
    if (n == 2) return x*x;

    long sign = n > 0? 1L:-1L;
    long e = n * sign;

    long rest = e % 2;
    long quo = e / 2;
    double half = myPow(x, (int) quo);
    double result = half * half * myPow(x, (int) rest);

    if (sign < 0) result = 1.0 / result;

    return result;
  }

  public static void main(String[] args) {
    Pow_50 solution = new Pow_50();
    System.out.println(solution.myPow(2.0, -2147483648));
    char[][] map = {{}, {}, {'a','b','c'}, {'d','e','f'},
                    {'g','h','i'}, {'j','k','l'}, {'m','n','o'},
                    {'p','q','r', 's'}, {'t','u', 'v'}, {'w','x', 'y', 'z'}};


    

  }


}

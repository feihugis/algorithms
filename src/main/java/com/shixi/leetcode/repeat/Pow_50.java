package com.shixi.leetcode.repeat;

/**
 * Created by Fei Hu on 8/21/17.
 */
public class Pow_50 {

  public double myPow(double x, int n) {
    if (x == 0 && n < 0) throw new IllegalArgumentException();
    if (x == 0 && n == 0) return 1;
    if (x == 0 && n > 0) return 0;
    if (n == 0) return 1;

    double result = x;
    long count = 1;

    while (count + count <= Math.abs(n)) {
      result = result * result;
      count = count + count;
    }

    int rest = (int) (Math.abs(n) - count);
    System.out.println("Rest is " + rest);

    result = rest > 0? result * myPow(x, rest) : result;
    result = n > 0? result : 1/result;

    return result;
  }

  public static void main(String[] args) {
    Pow_50 solution = new Pow_50();
    System.out.println(solution.myPow(2, 4));
  }


}

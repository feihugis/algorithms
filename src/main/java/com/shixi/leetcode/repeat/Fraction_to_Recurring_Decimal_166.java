package com.shixi.leetcode.repeat;

import java.util.HashMap;

/**
 * Created by Fei Hu on 9/2/17.
 */
public class Fraction_to_Recurring_Decimal_166 {
  public String fractionToDecimal(int numerator, int denominator) {
    long devidend = Long.valueOf(numerator);
    long devisor = Long.valueOf(denominator);
    int signal = devidend*devisor >= 0? 1:-1;
    devidend = Math.abs(devidend);
    devisor = Math.abs(devisor);

    StringBuilder fraction = new StringBuilder();
    HashMap<Long,Integer> set = new HashMap<Long,Integer>();
    int location = -1;

    long m = devidend % devisor;
    if (m == 0) return String.valueOf(devidend/devisor*signal);

    while (m*10L % devisor != 0) {
      location++;
      set.put(m, location);
      long value = m*10L/devisor;
      fraction.append(String.valueOf(value));
      m = m*10L % devisor;

      if (set.containsKey(m)) {
        int l = set.get(m);
        String result = String.format("%d.%s(%s)", devidend/devisor,
                                      fraction.toString().substring(0, l),
                                      fraction.substring(l));
        result = signal > 0? result: "-"+result;
        return result;
      }
    }


    fraction.append(m*10L / devisor);
    String result = devidend/devisor + "." + fraction.toString();
    result = signal > 0? result: "-"+result;
    return result;
  }

  public static void main(String[] args) {
    Fraction_to_Recurring_Decimal_166 solution = new Fraction_to_Recurring_Decimal_166();

    System.out.println(solution.fractionToDecimal( -2147483648, 1));
  }



}

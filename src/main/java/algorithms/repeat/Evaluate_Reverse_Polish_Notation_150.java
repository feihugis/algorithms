package algorithms.repeat;

import java.util.Stack;

/**
 * Created by Fei Hu on 9/1/17.
 */
public class Evaluate_Reverse_Polish_Notation_150 {
  public int evalRPN(String[] tokens) {
    Stack<Integer> stack = new Stack<Integer>();
    for (int i = 0; i < tokens.length; i++) {
      operate(tokens[i], stack);
    }

    return stack.pop();
  }

  public void operate(String s, Stack<Integer> stack) {
    int right, left;
    switch(s) {
      case "+":
        right = stack.pop();
        left = stack.pop();
        stack.push(left + right);
        break;
      case "-":
        right = stack.pop();
        left = stack.pop();
        stack.push(left - right);
        break;
      case "*":
        right = stack.pop();
        left = stack.pop();
        stack.push(left * right);
        break;
      case "/":
        right = stack.pop();
        left = stack.pop();
        stack.push(left / right);
        break;
      default:
        stack.push(Integer.parseInt(s));
    }
  }

  public static void main(String[] args) {
    Evaluate_Reverse_Polish_Notation_150 solution = new Evaluate_Reverse_Polish_Notation_150();
    String[] tokens = new String[]{"14", "13", "5", "/", "+"};
    System.out.println(solution.evalRPN(tokens));
  }

}

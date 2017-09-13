package algorithms.repeat;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by Fei Hu on 8/18/17.
 */
public class Word_Search_79 {
  class Node {
    int x;
    int y;
    public Node (int x, int y) {
      this.x = x;
      this.y = y;
    }
  }

  public boolean exist(char[][] board, String word) {
    if (board == null || board.length == 0 || board[0].length == 0 || word == null || word.isEmpty())
      throw new IllegalArgumentException();

    boolean[][] visited = new boolean[board.length][board[0].length];

    Stack<Node> stack = new Stack<Node>();

    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[0].length; j++) {
        if (!visited[i][j] && word.charAt(0) == board[i][j]) {
          stack.add(new Node(i, j));
        }
      }
    }

    while (!stack.isEmpty()) {
      Node node = stack.pop();
      visited[node.x][node.y] = true;
      if (exist(board, word.substring(1), node, visited)) return true;
      visited[node.x][node.y] = false;
    }

    return false;
  }

  public boolean exist(char[][] board, String word, Node node, boolean[][] visited) {
    if (word == null || word.isEmpty()) return true;

    Stack<Node> stack = new Stack<Node>();

    List<Node> neighbors = getNeighbors(board, node, visited, word.charAt(0));
    stack.addAll(neighbors);

    while (!stack.isEmpty()) {
      Node first_node = stack.pop();
      visited[first_node.x][first_node.y] = true;
      if (exist(board, word.substring(1), first_node, visited)) return true;
      visited[first_node.x][first_node.y] = false;
    }

    return false;
  }

  public List<Node> getNeighbors(char[][] board, Node node, boolean[][] visited, char c) {
    List<Node> result = new ArrayList<Node>();

    int h = board.length, w = board[0].length;

    int x = node.x, y = node.y;

    if (x - 1 >= 0 && x - 1 < h && !visited[x-1][y] && board[x - 1][y] == c)
      result.add(new Node(x - 1, y));

    if (x + 1 >= 0 && x + 1 < h && !visited[x+1][y] && board[x + 1][y] == c )
      result.add(new Node(x + 1, y));

    if (y - 1 >= 0 && y - 1 < w && !visited[x][y-1] && board[x][y-1] == c)
      result.add(new Node(x, y - 1));

    if (y + 1 >= 0 && y + 1 < w && !visited[x][y+1] && board[x][y+1] == c)
      result.add(new Node(x, y + 1));

    return result;
  }

  public static void main(String[] args) {
    char[][] board = new char[3][4];
    board[0] = "ABCE".toCharArray();
    board[1] = "SFES".toCharArray();
    board[2] = "ADEE".toCharArray();

    String word = "ABCEFSADEESE";
    Word_Search_79 solution = new Word_Search_79();

    System.out.println(solution.exist(board, word));


  }

}

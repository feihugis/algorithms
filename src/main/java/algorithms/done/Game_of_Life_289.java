package algorithms.done;

/**
 * Created by Fei Hu on 9/15/17.
 */
public class Game_of_Life_289 {
  public void gameOfLife(int[][] board) {
    if (board == null || board.length == 0 || board[0].length == 0) return;
    int height = board.length, width = board[0].length;
    for (int r = 0; r < height; r++) {
      for (int c = 0; c < width; c++) {
        updateStatus(board, height, width, r, c);
      }
    }

    for (int r = 0; r < height; r++) {
      for (int c = 0; c < width; c++) {
        board[r][c] = board[r][c] >> 1;
      }
    }

  }

  public void updateStatus(int[][] board, int height, int width, int r, int c) {
    int live = 0;

    for (int i = Math.max(0, r - 1); i <= Math.min(r+1, height - 1); i++) {
      for (int j = Math.max(0, c - 1); j <= Math.min(c+1, width - 1); j++) {
        if (i != r || j != c) {
          live += board[i][j] & 1;
        }
      }
    }

    if ((board[r][c]&1) == 1) {
      if (live >= 2 && live <= 3) board[r][c] = 3;
    } else {
      if (live == 3) board[r][c] = 2;
    }

    int[][] b = new int[2][3];

  }

}

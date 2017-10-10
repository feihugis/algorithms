package algorithms.repeat;

import java.util.HashMap;
import java.util.HashSet;

public class Lonely_Pixel_II_533 {
  public int findBlackPixel(char[][] picture, int N) {
    if (picture == null || picture.length < N || picture[0].length < N) {
      return 0;
    }

    HashMap<String, Integer> map = new HashMap<String, Integer>();
    int[] colCount = new int[picture[0].length];
    int[] rowCount = new int[picture.length];
    String[] rowStr = new String[picture.length];

    for (int i = 0; i < picture.length; i++) {
      StringBuilder str = new StringBuilder();
      for (int j = 0; j < picture[0].length; j++) {
        str.append(picture[i][j]);
        if (picture[i][j] == 'B') {
          colCount[j]++;
          rowCount[i]++;
        }
      }
      rowStr[i] = str.toString();
      map.put(rowStr[i], 1 + map.getOrDefault(rowStr[i], 0));
    }

    int result = 0;

    for (int j = 0; j < picture[0].length; j++) {
      HashSet<String> visited = new HashSet<String>();
      int num = 0;
      for (int i = 0; i < picture.length; i++) {
        if (picture[i][j] == 'B') {
          if (colCount[j] != N || rowCount[i] != N) {
            num = 0;
            break;
          } else if (visited.isEmpty()) {
            num = map.get(rowStr[i]);
            visited.add(rowStr[i]);
          } else if (!visited.contains(rowStr[i])) {
            num = 0;
            break;
          }
        }
      }
      result += num;
    }

    return result;
  }

}

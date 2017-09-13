package com.shixi.leetcode.repeat;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * Created by Fei Hu on 8/22/17.
 */
public class Rotate_Image_48 {

  //not the best way
  public void rotate(int[][] matrix) {
    if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
      throw new IllegalArgumentException();
    int n = matrix.length;

    int[][] copy = new int[n][n];
    for (int i = 0; i < n; i++) {
      System.arraycopy(matrix[i], 0, copy[i], 0, n);
    }

    for (int y = 0; y < n; y++) {
      for ( int x = 0; x < n; x++) {
        matrix[x][n-1-y] = copy[y][x];
      }
    }
  }

  public static void main(String[] args) {
    int[][] image = new int[][] {{1,2,3}, {4,5,6}, {7,8,9}};
    int[][] images = new int[3][3];
    for (int i = 0; i < image.length; i++) {
      System.arraycopy(image[i], 0, images[i], 0, image.length);
    }
    System.out.println(images[0][2]);
  }

}

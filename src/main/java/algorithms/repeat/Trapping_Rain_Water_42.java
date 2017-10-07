package algorithms.repeat;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Fei Hu on 9/22/17.
 */
public class Trapping_Rain_Water_42 {
  public int trap(int[] height) {
    if (height == null || height.length <= 2) return 0;
    int volume = 0;
    int[] leftMax = new int[height.length], rightMax = new int[height.length];
    leftMax[0] = height[0];
    rightMax[height.length - 1] = height[height.length - 1];

    for (int i = 1; i < height.length; i++) {
      leftMax[i] = Math.max(height[i], leftMax[i - 1]);
      rightMax[height.length - 1 - i] = Math.max(height[height.length - 1 - i], rightMax[height.length - i]);
    }

    for (int i = 0; i < height.length; i++) {
      volume += Math.min(leftMax[i], rightMax[i]) - height[i];
    }

    return volume;
  }

  public int[] getConvex(int[] height) {
    List<Integer> indices = new ArrayList<Integer>();
    int start = 0;
    while (start + 1 < height.length && height[start] <= height[start+1]) {
      start++;
    }
    indices.add(start);

    while (start < height.length) {
      int end = start+1;
      while (end + 1 < height.length && height[end] >= height[end+1]) {
        end++;
      }
      while (end + 1 < height.length && height[end] <= height[end+1]) {
        end++;
      }
      if (end < height.length && height[end] >= height[end-1]) {
        indices.add(end);
      }
      start = end;
    }

    int[] result = new int[indices.size()];

    for (int i = 0; i < result.length; i++) {
      result[i] = indices.get(i);
    }

    return result;
  }

  public int getVolume(int[] height, int start, int end) {
    int highest = Math.min(height[start], height[end]);
    int volume = 0;
    for (int i = start+1; i <= end-1; i++) {
      if (highest > height[i]) {
        volume = volume + highest - height[i];
      }
    }
    return volume;
  }

  public static void main(String[] args) {
    Trapping_Rain_Water_42 solution = new Trapping_Rain_Water_42();
    int[] input = new int[]{6,4,2,0,3,2,0,3,1,4,5,3,2,7,5,3,0,1,2,1,3,4,6,8,1,3};
    System.out.println(solution.trap(input));
    //[[0,0],[94911151,94911150],[94911152,94911151]]

    System.out.println((0 - 94911151)* 1.0 / (0- 94911150) == (0 - 94911152) * 1.0 / (0 - 94911151));
  }

}

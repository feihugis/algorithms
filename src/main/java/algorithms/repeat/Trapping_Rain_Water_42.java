package algorithms.repeat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Fei Hu on 9/22/17.
 */
public class Trapping_Rain_Water_42 {
  public int trap(int[] height) {
    if (height == null || height.length <= 2) return 0;
    int volume = 0, cur = 0;
    int left = 0, right = height.length - 1;

    while (left < right) {
      while (left < height.length - 1 && height[left] <= height[left+1]) left++;
      while (right >= 1 && height[right-1] >= height[right]) right--;

      if (height[left] < height[right]) {
        cur = left;
        while (height[cur] <= height[left]) {
          volume += height[left] - height[cur];
          cur++;
        }
        left = cur;
      } else if (height[left] > height[right]){
        cur = right;
        while (height[cur] <= height[right]) {
          volume += height[right] - height[cur];
          cur--;
        }
        right = cur;
      } else {
        cur = left;
        while (cur <= right && height[cur] <= height[left]) {
          volume += height[left] - height[cur];
          cur++;
        }
        left = cur;
      }
    }

    return volume;
  }

  public static void main(String[] args) {
    Trapping_Rain_Water_42 solution = new Trapping_Rain_Water_42();
    int[] input = new int[]{4, 2, 3};
    System.out.println(solution.trap(input));
    //[[0,0],[94911151,94911150],[94911152,94911151]]

    System.out.println((0 - 94911151)* 1.0 / (0- 94911150) == (0 - 94911152) * 1.0 / (0 - 94911151));
    System.out.println(Arrays.asList(1,2,3).getClass());
  }

}

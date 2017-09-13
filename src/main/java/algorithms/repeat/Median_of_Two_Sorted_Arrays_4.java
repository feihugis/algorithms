package algorithms.repeat;

/**
 * Created by Fei Hu on 8/14/17.
 */
public class Median_of_Two_Sorted_Arrays_4 {

  public double findMedianSortedArrays(int[] nums1, int[] nums2) {
    int len1 = nums1.length;
    int len2 = nums2.length;
    int itr1 = 0;
    int itr2 = 0;

    double median = 0.0;

    for (int i = 0; i <= (len1 + len2)/2; i++) {
      if (itr1 < len1 && (itr2 == len2 || nums1[itr1] <= nums2[itr2])) {
        if ((len1 + len2) % 2 != 0 && i == (len1 + len2)/2 ) {
          median = nums1[itr1];
          return median;
        }

        if ((len1 + len2) % 2 == 0 && i == (len1 + len2)/2 - 1) {
          median = median + nums1[itr1];
        }

        if ((len1 + len2) % 2 == 0 && i == (len1 + len2)/2 ) {
          median = (median + nums1[itr1])/2.0;
          return median;
        }
        itr1++;
        continue;

      } else if (itr2 < len2 && (itr1 == len1 || nums2[itr2] <= nums1[itr1] )) {
        if ((len1 + len2) % 2 != 0 && i == (len1 + len2)/2 ) {
          median = nums2[itr2];
          return median;
        }

        if ((len1 + len2) % 2 == 0 && i == (len1 + len2)/2 -1) {
          median = median + nums2[itr2];
        }

        if ((len1 + len2) % 2 == 0 && i == (len1 + len2)/2 ) {
          median = (median + nums2[itr2])/2.0;
          return median;
        }
        itr2++;

      }
    }

    return median;
  }

  public static void main(String[] args) {
    int[] nums1 = new int[] {1 , 2};
    int[] nums2 = new int[] {3 , 4};

    Median_of_Two_Sorted_Arrays_4 test = new Median_of_Two_Sorted_Arrays_4();

    double median = test.findMedianSortedArrays(nums1, nums2);
    System.out.println(median);
  }

}

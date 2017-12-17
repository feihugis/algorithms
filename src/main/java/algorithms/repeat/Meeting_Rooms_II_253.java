package algorithms.repeat;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by Fei Hu on 9/15/17.
 */

class Interval {
  int start;
  int end;
  Interval() { start = 0; end = 0; }
  Interval(int s, int e) { start = s; end = e; }
}

public class Meeting_Rooms_II_253 {

  public int minMeetingRooms(Interval[] intervals) {
    Arrays.sort(intervals, new Comparator<Interval>() {
      @Override
      public int compare(Interval o1, Interval o2) {
        return o1.start < o2.start? -1 : 1;
      }
    });
    int count = 0;
    for (int i = 0; i < intervals.length - 1; i++) {
      boolean overlap = true;
      for (int j = 0; j < i; j++) {
        if ( intervals[i].start >= intervals[j].end) {
          intervals[j].end = intervals[i].end;
          intervals[i] = intervals[j];
          overlap = false;
          break;
        }
      }
      if (overlap) count++;
    }
    return count;
  }

  public static void main(String[] args) {
    Meeting_Rooms_II_253 solution = new Meeting_Rooms_II_253();
    Interval[] input = new Interval[4];
    input[0] = new Interval(3, 5);
    input[1] = new Interval(5, 6);
    input[2] = new Interval(9, 14);
    input[3] = new Interval(12, 19);
    System.out.println(solution.minMeetingRooms(input));
  }



}

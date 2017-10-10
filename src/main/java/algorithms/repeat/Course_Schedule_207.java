package algorithms.repeat;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Course_Schedule_207 {
  public boolean canFinish(int numCourses, int[][] prerequisites) {
    if (prerequisites == null || prerequisites.length == 0 || prerequisites[0].length == 0) return true;
    List<Integer> avaCourse = new ArrayList<Integer>();
    int takenCourses = 0;
    for (int i = 0; i < numCourses; i++) {
      avaCourse.add(i);
    }

    int[] indegree = new int[numCourses];

    HashMap<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
    for (int[] p : prerequisites) {
      Integer next = p[0], pre = p[1];
      if (map.containsKey(pre)) {
        map.get(pre).add(next);
        map.put(pre, map.get(pre));
      } else {
        List<Integer> nextList = new ArrayList<Integer>();
        nextList.add(next);
        map.put(pre, nextList);
      }
      indegree[next]++;
      avaCourse.remove(next);
    }

    while(!avaCourse.isEmpty()) {
      Integer course = avaCourse.get(0);
      avaCourse.remove(0);
      takenCourses++;
      if(map.containsKey(course)) {
        List<Integer> nextCourses = map.get(course);
        for(Integer i : nextCourses) {
          indegree[i]--;
          if (indegree[i] == 0) {
            avaCourse.add(i);
          }
        }
      }
    }

    return takenCourses == numCourses;
  }

}

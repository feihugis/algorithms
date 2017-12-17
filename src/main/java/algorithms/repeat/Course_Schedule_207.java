package algorithms.repeat;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;

public class Course_Schedule_207 {
  public int[] canFinish(int numCourses, int[][] prerequisites) {
    if (prerequisites == null || prerequisites.length == 0 || prerequisites[0].length == 0) return null;

    int[] order = new int[numCourses];
    int[] indegree = new int[numCourses];
    HashMap<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();

    for (int[] entry : prerequisites) {
      indegree[entry[0]]++;
      List<Integer> val = map.getOrDefault(entry[1], new ArrayList<Integer>());
      val.add(entry[0]);
      map.put(entry[1], val);
    }

    Stack<Integer> stack = new Stack<Integer>();
    for (int i = 0; i < indegree.length; i++) {
      if (indegree[i] == 0) {
        stack.push(i);
      }
    }

    int index = 0;

    while (!stack.isEmpty()) {
      order[index] = stack.pop();
      if (map.containsKey(order[index])) {
        List<Integer> nextCourses = map.get(order[index]);
        for (Integer i : nextCourses) {
          indegree[i]--;
          if (indegree[i] == 0) {
            stack.push(i);
          }
        }
      }

      index++;
    }

    if (index < numCourses) return null;

    return order;
  }

  public static void main(String[] args) {
    Course_Schedule_207 solution = new Course_Schedule_207();
    int numCourses = 2;
    int[][] prerequisites = {{1, 0}};
    solution.canFinish(numCourses, prerequisites);
  }

}

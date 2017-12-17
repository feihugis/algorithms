package algorithms.repeat;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Random;
import java.util.Stack;

public class Reconstruct_Itinerary_332 {
  public List<String> findItinerary(String[][] tickets) {
    if(tickets == null || tickets.length == 0 || tickets[0].length == 0) return new ArrayList<String>();

    Map<String, PriorityQueue<String>> targets = new HashMap<>();
    for (String[] ticket : tickets)
      targets.computeIfAbsent(ticket[0], k -> new PriorityQueue()).add(ticket[1]);
    List<String> route = new LinkedList();
    Stack<String> stack = new Stack<>();
    stack.push("JFK");
    while (!stack.empty()) {
      while (targets.containsKey(stack.peek()) && !targets.get(stack.peek()).isEmpty())
        stack.push(targets.get(stack.peek()).poll());
      route.add(0, stack.pop());
    }
    return route;
  }

  public static void main(String[] args) {
    Reconstruct_Itinerary_332 solution = new Reconstruct_Itinerary_332();
    String[][] tickets = {{"JFK","KUL"},{"JFK","NRT"},{"NRT","JFK"}};
    System.out.println(solution.findItinerary(tickets));
    String[] ss = "sdf".split("\t");
    String[] space = "   a   b ".split(" ");
    int index = "abcdedf".indexOf("cde");
    System.out.println(ss.length);
    String[] s = {"a", "b", "c"};
    System.out.println(String.join("_", s));
  }

}

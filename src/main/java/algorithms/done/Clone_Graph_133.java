package algorithms.done;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;

public class Clone_Graph_133 {
  class UndirectedGraphNode {
      int label;
      List<UndirectedGraphNode> neighbors;
      UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
  }

  public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
    if (node == null) return null;

    Stack<UndirectedGraphNode> stack = new Stack<UndirectedGraphNode>();
    UndirectedGraphNode head = new UndirectedGraphNode(node.label);
    stack.add(node);
    HashMap<Integer, UndirectedGraphNode> map = new HashMap<Integer, UndirectedGraphNode>();
    map.put(head.label, head);

    while(!stack.isEmpty()) {
      UndirectedGraphNode cur = stack.pop();
      UndirectedGraphNode clnNode = map.get(cur.label);
      List<UndirectedGraphNode> neighbors = cur.neighbors;
      for(int i = 0; i < neighbors.size(); i++) {
        UndirectedGraphNode n = neighbors.get(i);
        if(map.containsKey(n.label)) {
          clnNode.neighbors.add(map.get(n.label));
        } else {
          UndirectedGraphNode newNode = new UndirectedGraphNode(n.label);
          clnNode.neighbors.add(newNode);
          map.put(newNode.label, newNode);
          stack.push(n);
        }
      }
    }

    return head;
  }


}

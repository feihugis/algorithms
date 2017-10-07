package algorithms.repeat;

import java.util.HashMap;

public class House_Robber_III_337 {
  public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
  HashMap<TreeNode, Integer> map = new HashMap<TreeNode, Integer>();

  public int rob(TreeNode root) {
    if (root == null) return 0;
    if (map.containsKey(root)) return map.get(root);
    int m1 = root.val;
    int m2 = 0;
    if (root.left != null) {
      m2 += rob(root.left);
      m1 += rob(root.left.left) + rob(root.left.right);
    }
    if (root.right != null) {
      m2 += rob(root.right);
      m1 += rob(root.right.left) + rob(root.right.right);
    }
    int result = Math.max(m1, m2);
    map.put(root, result);
    return result;
  }
}

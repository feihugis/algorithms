package algorithms.repeat;

import java.util.Arrays;

public class Construct_Binary_Tree_from_Inorder_and_Postorder_Traversal_106 {

  public TreeNode buildTree(int[] inorder, int[] postorder) {
    if (inorder == null || inorder.length == 0
        || postorder == null || postorder.length == 0
        || inorder.length != postorder.length) return null;

    return buildTree(inorder, 0, inorder.length - 1, postorder, 0, postorder.length-1);
  }

  public TreeNode buildTree(int[] inorder, int in_start, int in_end, int[] postorder, int post_start, int post_end) {
    if (in_start > in_end || post_start > post_end) return null;

    int val = postorder[post_end];
    int location = locate(inorder, in_start, in_end, val);
    if (location == -1) {
      throw new IllegalArgumentException();
    }

    TreeNode root = new TreeNode(val);

    root.left = buildTree(inorder, in_start, location-1, postorder, post_start, post_start + location - in_start - 1);

    root.right = buildTree(inorder, location+1, in_end, postorder, post_start + location - in_start, post_end-1);

    return root;
  }

  public int locate(int[] array, int start, int end, int val) {
    for (int i = start; i <= end; i++) {
      if (array[i] == val) {
        return i;
      }
    }
    return -1;
  }

  public static void main(String[] args) {
    Construct_Binary_Tree_from_Inorder_and_Postorder_Traversal_106 solution = new Construct_Binary_Tree_from_Inorder_and_Postorder_Traversal_106();
    int[] inorder = {1, 2}, postorder = {2, 1};
    System.out.println(solution.buildTree(inorder, postorder));
  }

}

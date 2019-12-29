// start    2019-12-28 10:16:36
// finish   2019-12-28 10:43:50

import java.util.*;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> list = new ArrayList<>();
        TreeNode p = root;
        while ( p != null || !stack.empty() ) {
            while ( p != null ) {
                stack.add(p);
                p = p.left;
            }
            p = stack.pop();
            list.add(p.val);
            p = p.right;
        }
        return list;
    }

    List<Integer> recursiveTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        recursive(root, list);
        return list;
    }

    void recursive(TreeNode root, List<Integer> list) {
        if ( root == null ) return;
        if ( root.left != null ) recursive(root.left, list);
        list.add(root.val);
        if ( root.right != null ) recursive(root.right, list);
    }
}

public class Main {
    public static void main(String[] args) {
        TreeNode n;
        n = Gardener.grow(new Integer[] {1,null,2,3});
        check(n);
    }

    static void check(TreeNode n) {
        Solution s = new Solution();
        List<Integer> list = s.inorderTraversal(n);
        System.out.println(list);
    }

}

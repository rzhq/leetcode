// start    2019-12-31 14:48:40
// finish   2019-12-31 15:02:47

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
    public List<Integer> preorderTraversal(TreeNode root) {
        //List<Integer> list = new ArrayList<>();
        //recursive(root, list);
        //return list;
        return iterative(root);
    }

    void recursive(TreeNode n, List<Integer> list) {
        if ( n == null ) return;
        list.add(n.val);
        recursive(n.left, list);
        recursive(n.right, list);
    }

    List<Integer> iterative(TreeNode n) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        while ( n != null || !stack.empty() ) {
            while ( n != null ) {
                list.add(n.val);
                stack.push(n);
                n = n.left;
            }
            n = stack.pop();
            n = n.right;
        }
        return list;
    }
}

public class Main {
    public static void main(String[] args) {
        TreeNode n;
        n = Gardener.grow(new Integer[] {});
        check(n, "[]");
        n = Gardener.grow(new Integer[] {1});
        check(n, "[1]");
        n = Gardener.grow(new Integer[] {1,2,3,4,5});
        check(n, "[1, 2, 4, 5, 3]");
        n = Gardener.grow(new Integer[] {1,null,2,3,4,5});
        check(n, "[1, 2, 3, 5, 4]");
    }

    static void check(TreeNode n, String out) {
        Solution s = new Solution();
        List<Integer> ret = s.preorderTraversal(n);
        System.out.println(ret);
        System.out.printf("%s\n", out);
    }

}

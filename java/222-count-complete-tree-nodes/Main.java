// start    2019-12-31 16:17:21
// finish   2019-12-31 16:31:56

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
    public int countNodes(TreeNode root) {
        return recursive(root);
        //return iterative(root);
    }

    int iterative(TreeNode root) {
        int count = 0;
        Stack<TreeNode> stack = new Stack<>();
        while ( root != null || !stack.empty() ) {
            while ( root != null ) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            count++;
            root = root.right;
        }
        return count;
    }

    int recursive(TreeNode root) {
        int h = height(root);
        if ( h < 0 ) return 0;
        if ( h - 1 == height(root.right) ) {
            return ( 1 << h ) + recursive(root.right);
        } else {
            return ( 1 << h-1 ) + recursive(root.left);
        }
    }

    int height(TreeNode n) {
        return n == null ? -1 : 1 + height(n.left);
    }
}

public class Main {
    public static void main(String[] args) {
        TreeNode n;
        n = Gardener.grow(new Integer[] {1,2,3,4,5});
        check(n, 5);
    }

    static void check(TreeNode n, int out) {
        Solution s = new Solution();
        int ret = s.countNodes(n);
        System.out.printf("%d %d\n", ret, out);
    }

}

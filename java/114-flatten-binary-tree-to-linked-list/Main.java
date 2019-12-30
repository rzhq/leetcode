// start    2019-12-30 11:09:37
// finish   2019-12-30 12:00:19

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
    public void flatten(TreeNode root) {
        //recursive(root, null);
        iterative(root);
    }

    void iterative(TreeNode root) {
        TreeNode curr = root, p = root;
        while ( curr != null ) {
            if ( curr.left != null ) {
                p = curr.left;
                while ( p.right != null ) p = p.right;
                p.right = curr.right;
                curr.right = curr.left;
                curr.left = null;
            }
            curr = curr.right;
        }
    }

    TreeNode recursive(TreeNode root, TreeNode prev) {
        if ( root == null ) return prev;
        prev = recursive(root.right, prev);
        prev = recursive(root.left, prev);
        root.right = prev;
        root.left = null;
        return root;
    }
}

public class Main {
    public static void main(String[] args) {
        TreeNode n;
        n = Gardener.grow(new Integer[] {1,2,3,4,5});
        check(n);
    }

    static void check(TreeNode n) {
        Solution s = new Solution();
        Gardener.print(n);
        s.flatten(n);
        Gardener.print(n);
    }

}

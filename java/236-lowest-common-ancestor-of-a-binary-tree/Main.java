// start    2019-12-31 22:27:02
// finish   2019-12-31 22:51:34

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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return recursive(root, p, q);
    }

    TreeNode recursive(TreeNode root, TreeNode p, TreeNode q) {
        if ( root == null ) return null;
        if ( root == p || root == q ) return root;
        TreeNode left = recursive(root.left, p, q);
        TreeNode right = recursive(root.right, p, q);
        if ( left == null ) return right;
        if ( right == null ) return left;
        return root;
    }
}

public class Main {
    public static void main(String[] args) {
        TreeNode n, p, q;
        n = Gardener.grow(new Integer[] {1,2,3,4,5});
        p = n.left.left; q = n.right;
        check(n, p, q, 1);
    }

    static void check(TreeNode n, TreeNode p, TreeNode q, int out) {
        Solution s = new Solution();
        TreeNode r = s.lowestCommonAncestor(n, p, q);
        System.out.printf("%d %d\n", r.val, out);
    }

}

// start    2019-12-29 14:53:37
// finish   2019-12-29 15:17:39

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
    public boolean isValidBST(TreeNode root) {
        return recursive(root, null, null);
        //return iterative(root);
    }

    boolean iterative(TreeNode root) {
        if ( root == null ) return true;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode n = root, pre = null;
        while ( n != null || !stack.empty() ) {
            while ( n != null ) {
                stack.push(n);
                n = n.left;
            }
            n = stack.pop();
            if ( pre != null && pre.val >= n.val ) return false;
            pre = n;
            n = n.right;
        }
        return true;
    }

    boolean recursive(TreeNode root, Integer min, Integer max) {
        if ( root == null ) return true;
        if ( (max != null && root.val >= max) || (min != null && root.val <= min) ) return false;
        return recursive(root.left, min, root.val) && recursive(root.right, root.val, max);
    }
}

public class Main {
    public static void main(String[] args) {
        TreeNode n;
        n = Gardener.grow(new Integer[] {2,1,3});
        check(n, true);
        n = Gardener.grow(new Integer[] {2,2,3});
        check(n, false);
        n = Gardener.grow(new Integer[] {5,1,4,null,null,3,6});
        check(n, false);
        n = Gardener.grow(new Integer[] {10,5,15,null,null,6,20});
        check(n, false);
        n = Gardener.grow(new Integer[] {2147483647});
        check(n, true);
    }

    static void check(TreeNode n, boolean out) {
        Solution s = new Solution();
        boolean ret = s.isValidBST(n);
        System.out.printf("%s %s\n", ret, out);
    }

}

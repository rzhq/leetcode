// start    2019-12-31 10:53:00
// finish   2019-12-31 11:16:41

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
    public int sumNumbers(TreeNode root) {
        return recursive(root, 0);
    }

    int recursive(TreeNode n, int base) {
        if ( n == null ) return 0;
        int val = base + n.val;
        if ( n.left == null && n.right == null ) return val;
        else return recursive(n.left, val * 10) + recursive(n.right, val * 10);
    }
}

public class Main {
    public static void main(String[] args) {
        TreeNode n;
        n = Gardener.grow(new Integer[] {});
        check(n, 0);
        n = Gardener.grow(new Integer[] {2});
        check(n, 2);
        n = Gardener.grow(new Integer[] {1,2,3});
        check(n, 25);
        n = Gardener.grow(new Integer[] {4,9,0,5,1});
        check(n, 1026);
    }

    static void check(TreeNode n, int out) {
        Solution s = new Solution();
        int ret = s.sumNumbers(n);
        System.out.printf("%d %d\n", ret, out);
    }

}

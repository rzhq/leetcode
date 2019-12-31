// start    2019-12-31 18:37:49
// finish   2019-12-31 18:43:18

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
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();
        while ( root != null || !stack.empty() ) {
            while ( root != null ) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if ( --k == 0 ) return root.val;
            root = root.right;
        }
        return 0;
    }
}

public class Main {
    public static void main(String[] args) {
        TreeNode n;
        n = Gardener.grow(new Integer[] {1,2,3,4,5});
        check(n, 3, 5);
    }

    static void check(TreeNode n, int k, int out) {
        Solution s = new Solution();
        int ret = s.kthSmallest(n, k);
        System.out.printf("%d %d\n", ret, out);
    }

}

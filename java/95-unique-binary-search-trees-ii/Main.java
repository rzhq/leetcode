// start    2020-01-16 20:15:41
// finish   2020-01-16 20:26:03

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
    public List<TreeNode> generateTrees(int n) {
        return gen(1, n);
    }

    List<TreeNode> gen(int start, int end) {
        List<TreeNode> list = new ArrayList<>();
        if ( start > end ) {
            list.add(null);
            return list;
        }
        List<TreeNode> left, right;
        for ( int i = start; i <= end; ++i ) {
            left = gen(start, i-1);
            right = gen(i+1, end);
            for ( TreeNode l : left ) {
                for ( TreeNode r : right ) {
                    TreeNode root = new TreeNode(i);
                    root.left = l;
                    root.right = r;
                    list.add(root);
                }
            }
        }
        return list;
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
        System.out.printf("\n");
    }

}

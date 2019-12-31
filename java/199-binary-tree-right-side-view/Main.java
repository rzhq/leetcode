// start    2019-12-31 15:55:30
// finish   2019-12-31 16:16:27

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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        recursive(root, 0, list);
        return list;
    }

    void recursive(TreeNode n, int depth, List<Integer> list) {
        if ( n == null ) return;
        if ( depth == list.size() ) list.add(n.val);
        recursive(n.right, depth+1, list);
        recursive(n.left, depth+1, list);
    }
}

public class Main {
    public static void main(String[] args) {
        TreeNode n;
        n = Gardener.grow(new Integer[] {1,2,3,4,5});
        check(n);
    }

    static void check(TreeNode n) {
        Gardener.print(n);
        Solution s = new Solution();
        List<Integer> ret = s.rightSideView(n);
        System.out.println(ret);
    }

}

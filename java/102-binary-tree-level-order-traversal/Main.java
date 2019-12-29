// start    2019-12-29 15:18:35
// finish   2019-12-29 15:35:46

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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        dfs(root, 0, list);
        return list;
    }

    void dfs(TreeNode n, int level, List<List<Integer>> list) {
        if ( n == null ) return;
        if ( list.size() <= level ) list.add(new ArrayList<Integer>());
        List<Integer> l = list.get(level);
        l.add(n.val);
        dfs(n.left, level+1, list);
        dfs(n.right, level+1, list);
    }
}

public class Main {
    public static void main(String[] args) {
        TreeNode n;
        n = Gardener.grow(new Integer[] {3,9,20,null,null,15,7});
        check(n);
        n = Gardener.grow(new Integer[] {3,9});
        check(n);
        n = Gardener.grow(new Integer[] {3});
        check(n);
        n = Gardener.grow(new Integer[] {});
        check(n);
    }

    static void check(TreeNode n) {
        Solution s = new Solution();
        List<List<Integer>> ret = s.levelOrder(n);
        System.out.println(ret);
    }

}

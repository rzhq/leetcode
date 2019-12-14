// start  2019-12-14 13:58:02
// finish 2019-12-14 14:11:48

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
    public boolean hasPathSum(TreeNode root, int sum) {
        if ( root == null ) return false;
        if ( root.val == sum && root.left == null && root.right == null ) return true;
        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
    }
}

public class Main {
    public static void main(String[] args) {
        TreeNode n;
        n = Gardener.grow(new Integer[] {1,2,3,4,5});
        check(n, 8, true);
        n = Gardener.grow(new Integer[] {});
        check(n, 8, false);
        n = Gardener.grow(new Integer[] {1});
        check(n, 1, true);
        n = Gardener.grow(new Integer[] {1});
        check(n, 8, false);
        n = Gardener.grow(new Integer[] {1,2});
        check(n, 3, true);
        n = Gardener.grow(new Integer[] {1,2});
        check(n, 1, false);
        n = Gardener.grow(new Integer[] {5,4,6,11,13,4,6,2,null,1});
        check(n, 22, true);
    }

    static void check(TreeNode n, int sum, boolean out) {
        Solution s = new Solution();
        boolean ret = s.hasPathSum(n, sum);
        System.out.printf("%s %s\n", ret, out);
    }

}

class TreeNode {
    public Integer val;
    public TreeNode left;
    public TreeNode right;
    TreeNode(Integer x) { val = x; }
}

class Gardener {
    public static TreeNode grow(Integer[] input) {
        TreeNode[] nodes = new TreeNode[input.length];
        if ( input == null || input.length < 1 ) return null;
        nodes[0] = new TreeNode(input[0]);
        for ( int i = 1; i < input.length; i++ ) {
            nodes[i] = input[i] == null ? null : new TreeNode(input[i]);
            if ( nodes[i] == null ) continue;
            if ( i % 2 == 0 ) {
                nodes[(i-1)/2].right = nodes[i];
            } else {
                nodes[i/2].left = nodes[i];
            }
        }
        return nodes[0];
    }

    public static void print(TreeNode root) {
        TreeNode right = root;
        int c = 1;
        while(right != null) { c = 2*c+1; right = right.right; }
        TreeNode[] q = new TreeNode[2*c+1];
        int i = 0, j = 0, n = 0;
        q[0] = root;
        for ( ; i < q.length; i++ ) {
            if ( q[i] == null ) break;
            System.out.printf("%d ", q[i].val);
            if ( i % 2 == 0 ) System.out.print("| ");
            if ( i >= n ) { System.out.println(); n = 2*n+2; };
            if ( q[i].left != null ) q[++j] = q[i].left;
            if ( q[i].right != null ) q[++j] = q[i].right;
        }
        System.out.print("\n\n");
    }
}

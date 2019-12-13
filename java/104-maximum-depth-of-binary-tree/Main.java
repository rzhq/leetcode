// start  2019-12-13 21:07:27
// finish 2019-12-13 21:27:58

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
    public int maxDepth(TreeNode root) {
        if ( root == null ) return 0;
        return 1 + Math.max( maxDepth(root.left), maxDepth(root.right) ) ;
    }
}

public class Main {
    public static void main(String[] args) {
        TreeNode n;
        n = Gardener.grow(new Integer[] {3,9,20,null,null,15,7});
        check(n, 3);
        n = Gardener.grow(new Integer[] {});
        check(n, 0);
        n = Gardener.grow(new Integer[] {1});
        check(n, 1);
        n = Gardener.grow(new Integer[] {1, 2});
        check(n, 2);
    }

    static void check(TreeNode n, int out) {
        Solution s = new Solution();
        int ret = s.maxDepth(n);
        System.out.printf("%d %d\n", ret, out);
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
            nodes[i] = new TreeNode(input[i]);
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
            if ( q[i] == null ) return;
            System.out.printf("%d ", q[i].val);
            if ( i % 2 == 0 ) System.out.print("| ");
            if ( i >= n ) { System.out.println(); n = 2*n+2; };
            if ( q[i].left != null ) q[++j] = q[i].left;
            if ( q[i].right != null ) q[++j] = q[i].right;
        }
    }
}

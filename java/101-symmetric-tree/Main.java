// start  2019-12-13 15:36:10
// finish 2019-12-13 16:07:21

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
    public boolean isSymmetric(TreeNode root) {
        if ( root == null ) return true;
        return checkSymm(root.left, root.right);
    }
    
    boolean checkSymm(TreeNode p, TreeNode q) {
        if ( p == null || q == null ) return p == q;
        if ( p.val != q.val ) return false;
        return checkSymm(p.left, q.right) && checkSymm(q.left, p.right);
    }
}

public class Main {
    public static void main(String[] args) {
        TreeNode node;
        node = Gardener.grow(new Integer[] {});
        check(node, true);
        node = Gardener.grow(new Integer[] {1,2,2,3,4,4,3});
        check(node, true);
        node = Gardener.grow(new Integer[] {1,2,2,null,3,null,3});
        check(node, false);
        node = Gardener.grow(new Integer[] {1});
        check(node, true);
        node = Gardener.grow(new Integer[] {1,2,2});
        check(node, true);
        node = Gardener.grow(new Integer[] {1,2});
        check(node, false);
    }

    static void check(TreeNode n, boolean out) {
        Solution s = new Solution();
        boolean ret = s.isSymmetric(n);
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
        if ( input == null || input.length < 1 ) return new TreeNode(null);
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

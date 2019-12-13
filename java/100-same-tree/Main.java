// start  2019-12-13 12:47:43
// finish 2019-12-13 14:11:03

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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if ( p == null && q == null ) return true;
        if ( p == null || q == null ) return false;
        if ( p.val != q.val ) return false;
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}

public class Main {
    public static void main(String[] args) {
        TreeNode m, n;
        m = Gardener.grow(new Integer[] {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16});
        n = Gardener.grow(new Integer[] {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16});
        check(m, n);
        m = Gardener.grow(new Integer[] {1,2,3,4,5,6,7,8,9,10,11,12,13,null,15,16});
        n = Gardener.grow(new Integer[] {1,2,3,4,5,6,7,8,9,10,11,12,13,null,11,16});
        check(m, n);
        m = Gardener.grow(new Integer[] {1,2,null,null,3});
        n = Gardener.grow(new Integer[] {1,2,null,null,3});
        check(m, n);
        m = Gardener.grow(new Integer[] {1,2,3,4,5,6,7,8,9,10});
        n = Gardener.grow(new Integer[] {1,2,3,4,5,6,7,8,null,10});
        check(m, n);
        m = Gardener.grow(new Integer[] {1});
        n = Gardener.grow(new Integer[] {1});
        check(m, n);
        m = Gardener.grow(new Integer[] {2});
        n = Gardener.grow(new Integer[] {1});
        check(m, n);
        m = Gardener.grow(new Integer[] {});
        n = Gardener.grow(new Integer[] {});
        check(m, n);
        m = Gardener.grow(new Integer[] {1,2});
        n = Gardener.grow(new Integer[] {1,null,2});
        check(m, n);
    }

    static void check(TreeNode m, TreeNode n) {
        Solution s = new Solution();
        boolean ret = s.isSameTree(m, n);
        System.out.println(ret);
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

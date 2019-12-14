// start  2019-12-14 15:45:25
// finish 2019-12-14 16:40:11

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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if ( root == null ) return null;
        if ( p.val < root.val && q.val < root.val ) return lowestCommonAncestor(root.left, p, q);
        if ( p.val > root.val && q.val > root.val ) return lowestCommonAncestor(root.right, p, q);
        if ( findNode(root, p) != null && findNode(root, q) != null ) return root;
        return null;
    }

    TreeNode findNode(TreeNode root, TreeNode node) {
        if ( root == null || node == null ) return null;
        if ( root.val == node.val ) return root;
        if ( root.val > node.val ) return findNode(root.left, node);
        else return findNode(root.right, node);
    }
}

public class Main {
    public static void main(String[] args) {
        TreeNode n;
        n = Gardener.grow(new Integer[] {6,2,8,0,4,7,9,null,null,3,5});
        check(n, 2, 8, 6);
        n = Gardener.grow(new Integer[] {6,2,8,0,4,7,9,null,null,3,5});
        check(n, 2, 4, 2);
        n = Gardener.grow(new Integer[] {6,2,8,0,4,7,9,null,null,3,5});
        check(n, 1, 4, null);
        n = Gardener.grow(new Integer[] {});
        check(n, 1, 1, null);
        n = Gardener.grow(new Integer[] {1});
        check(n, 1, 1, 1);
        n = Gardener.grow(new Integer[] {1});
        check(n, 1, 2, null);
        n = Gardener.grow(new Integer[] {2,1,3});
        check(n, 1, 3, 2);
    }

    static void check(TreeNode n, int p, int q, Integer out) {
        Solution s = new Solution();
        TreeNode ret = s.lowestCommonAncestor(n, new TreeNode(p), new TreeNode(q));
        System.out.printf("%s %s\n", ret == null ? ret : ret.val, out);
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

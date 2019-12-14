// start  2019-12-14 16:40:44
// finish 2019-12-14 17:02:27

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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> list = new ArrayList<String>();
        if ( root == null ) return list;
        walk(root, "", list);
        return list;
    }

    void walk(TreeNode root, String str, List<String> list) {
        if ( str.isEmpty() ) str = String.valueOf(root.val); else str += "->" + String.valueOf(root.val);
        if ( root.left == null && root.right == null ) { list.add(str); return; }
        if ( root.left != null ) walk(root.left, str, list);
        if ( root.right != null ) walk(root.right, str, list);
    }
}

public class Main {
    public static void main(String[] args) {
        TreeNode n;
        n = Gardener.grow(new Integer[] {1,2,3,null,5});
        check(n);
        n = Gardener.grow(new Integer[] {});
        check(n);
        n = Gardener.grow(new Integer[] {1});
        check(n);
        n = Gardener.grow(new Integer[] {1,2});
        check(n);
        n = Gardener.grow(new Integer[] {1,null,2});
        check(n);
        n = Gardener.grow(new Integer[] {1,2,3});
        check(n);
        n = Gardener.grow(new Integer[] {1,2,3,4,null,null,7,8});
        check(n);
        n = Gardener.grow(new Integer[] {1,2,3,4,5,6,7,8});
        check(n);
    }

    static void check(TreeNode n) {
        Solution s = new Solution();
        List<String> ret = s.binaryTreePaths(n);
        System.out.print(ret);
        System.out.printf("\n");
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

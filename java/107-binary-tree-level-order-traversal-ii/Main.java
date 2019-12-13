// start  2019-12-13 21:29:28
// finish 2019-12-13 22:28:04

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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        walk(root, list, 0);
        Collections.reverse(list);
        return list;
    }

    void walk(TreeNode node, List<List<Integer>> list, int d) {
        if ( node == null ) return;
        while ( list.size() <= d ) list.add(new ArrayList<Integer>());
        List<Integer> l = list.get(d);
        l.add(node.val);
        list.set(d, l);
        walk(node.left, list, d+1);
        walk(node.right, list, d+1);
    }
}

public class Main {
    public static void main(String[] args) {
        TreeNode n;
        n = Gardener.grow(new Integer[] {3,9,20,null,null,15,7});
        check(n);
        n = Gardener.grow(new Integer[] {});
        check(n);
        n = Gardener.grow(new Integer[] {1});
        check(n);
        n = Gardener.grow(new Integer[] {1,2});
        check(n);
        n = Gardener.grow(new Integer[] {1,null,2});
        check(n);
        n = Gardener.grow(new Integer[] {1,2,3,null,5,null,null,null,null,10,11});
        check(n);
    }

    static void check(TreeNode n) {
        Solution s = new Solution();
        List<List<Integer>> ret = s.levelOrderBottom(n);
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
        if ( input == null || input.length < 1 ) return null;
        nodes[0] = new TreeNode(input[0]);
        for ( int i = 1; i < input.length; i++ ) {
            nodes[i] = input[i] == null ? null : new TreeNode(input[i]);
            if ( nodes[i] == null ) continue;
            System.out.println(i);
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

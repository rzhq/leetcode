// start  2019-12-21 20:07:08
// finish 2019-12-21 20:21:37

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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return build(postorder, postorder.length-1, inorder, 0, inorder.length-1);
    }
    
    TreeNode build(int[] postorder, int p, int[] inorder, int head, int tail) {
        if ( p < 0 || head > tail ) return null;
        TreeNode node = new TreeNode(postorder[p]);
        for ( int i = head; i <= tail; i++ ) {
            if ( inorder[i] == postorder[p] ) {
                node.right = build(postorder, p-1, inorder, i+1, tail);
                node.left = build(postorder, p+i-tail-1, inorder, head, i-1);
                break;
            }
        }
        return node;
    }
}

public class Main {
    public static void main(String[] args) {
        int[] post, in;
        Integer[] out;
        in = new int[] {9,3,15,20,7};
        post = new int[] {9,15,7,20,3};
        out = new Integer[] {3,9,20,null,null,15,7};
        check(in, post, out);
        in = new int[] {2,1};
        post = new int[] {2,1};
        out = new Integer[] {1,2};
        check(in, post, out);
    }

    static void check(int[] in, int[] post, Integer[] out) {
        Solution s = new Solution();
        TreeNode n = s.buildTree(in, post);
        Gardener.print(n);
        System.out.println(Arrays.toString(out));
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

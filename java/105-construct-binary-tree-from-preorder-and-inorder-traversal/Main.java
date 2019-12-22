// start  2019-12-21 15:32:32
// finish 2019-12-21 16:24:31

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
    int p = 0, i = 0;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return build(preorder, inorder, null);
    }

    TreeNode build(int[] preorder, int[] inorder, Integer stopAt) {
        if ( i >= inorder.length || ( stopAt != null && inorder[i] == stopAt ) ) return null;
        TreeNode node = new TreeNode(preorder[p++]);
        node.left = build(preorder, inorder, node.val);
        i++;
        node.right = build(preorder, inorder, stopAt);
        return node;
    }

    public TreeNode buildTreeN2(int[] preorder, int[] inorder) {
        return build(preorder, 0, inorder, 0, inorder.length-1);
    }
    
    TreeNode build(int[] preorder, int cur, int[] inorder, int head, int tail) {
        if ( cur > preorder.length-1 || head > tail ) return null;
        TreeNode node = new TreeNode(preorder[cur]);
        for ( int i = head; i <= tail; i++ ) {
            if ( preorder[cur] == inorder[i] ) {
                node.left = build(preorder, cur+1, inorder, head, i-1);
                node.right = build(preorder, cur+i-head+1, inorder, i+1, tail);
                break;
            }
        }
        return node;
    }
}

public class Main {
    public static void main(String[] args) {
        int[] pre, in;
        Integer[] out;
        pre = new int[] {3,9,20,15,7};
        in = new int[] {9,3,15,20,7};
        out = new Integer[] {3,9,20,null,null,15,7};
        check(pre, in, out);
    }

    static void check(int[] pre, int[] in, Integer[] out) {
        Solution s = new Solution();
        TreeNode n = s.buildTree(pre, in);
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

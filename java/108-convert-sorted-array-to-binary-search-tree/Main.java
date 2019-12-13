// start  2019-12-13 22:33:41
// finish 2019-12-13 23:22:11

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
    public TreeNode sortedArrayToBST(int[] nums) {
        return findRoot(nums, 0, nums.length-1);
    }
    
    TreeNode findRoot (int[] nums, int i, int j) {
        if ( i == j ) return new TreeNode(nums[i]);
        if ( i > j ) return null;
        int m = ( i + j + 1 ) / 2;
        TreeNode node = new TreeNode(nums[m]);
        node.left = findRoot(nums, i, m - 1);
        node.right = findRoot(nums, m + 1, j);
        return node;
    }
}

public class Main {
    public static void main(String[] args) {
        TreeNode n;
        int[] in;
        in = new int[] {0,1,2,3,4,5,6,7};
        check(in);
        in = new int[] {0,1,2,3,4,5,6,7,8};
        check(in);
        in = new int[] {};
        check(in);
        in = new int[] {1};
        check(in);
        in = new int[] {1,2};
        check(in);
        in = new int[] {1,2,3};
        check(in);
    }

    static void check(int[] in) {
        Solution s = new Solution();
        Gardener.print(s.sortedArrayToBST(in));
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
            if ( i > 0 && q[i] == null && q[(i+1)/2-1] == null ) break;
            System.out.printf("%d ", q[i] == null ? q[i] : q[i].val);
            if ( i % 2 == 0 ) System.out.print("| ");
            if ( i >= n ) { System.out.println(); n = 2*n+2; };
            if ( q[i] != null ) {
                q[++j] = q[i].left;
                q[++j] = q[i].right;
            }
        }
        System.out.print("\n\n");
    }
}

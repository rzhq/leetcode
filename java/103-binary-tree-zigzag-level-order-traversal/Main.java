// start    2019-12-29 20:12:29
// finish   2019-12-29 21:18:23

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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if ( root == null ) return list;
        Queue<TreeNode> q = new LinkedList<>();
        int depth = 0;
        q.add(root);
        while ( !q.isEmpty() ) {
            int size = q.size();
            List<Integer> l = new LinkedList<>();
            for ( int i = 0; i < size; i++ ) {
                TreeNode n = q.remove();
                if ( depth % 2 == 0 ) l.add(n.val);
                else l.add(0, n.val);
                if ( n.left != null ) q.add(n.left);
                if ( n.right != null ) q.add(n.right);
            }
            list.add(l);
            depth++;
        }
        return list;
    }

    public List<List<Integer>> flip(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if ( root == null ) return list;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while ( !q.isEmpty() ) {
            int j = q.size();
            List<Integer> l = new ArrayList<>();
            for ( int i = 0; i < j; i++ ) {
                TreeNode n = q.remove();
                l.add(n.val);
                if ( n.left != null ) q.add(n.left);
                if ( n.right != null ) q.add(n.right);
            }
            list.add(l);
        }
        for ( int i = 1; i < list.size(); i += 2 ) {
            List<Integer> l = list.get(i);
            int j = 0, k = l.size()-1;
            while ( j < k ) {
                int tmp = l.get(j);
                l.set(j++, l.get(k));
                l.set(k--, tmp);
            }
        } 
        return list;
    }
}

public class Main {
    public static void main(String[] args) {
        TreeNode n;
        n = Gardener.grow(new Integer[] {});
        check(n);
        n = Gardener.grow(new Integer[] {1});
        check(n);
        n = Gardener.grow(new Integer[] {1,2});
        check(n);
        n = Gardener.grow(new Integer[] {1,2,3,4,5});
        check(n);
        n = Gardener.grow(new Integer[] {1,2,3,4,5,6,7,8,9,10,11,12,13,14});
        check(n);
    }

    static void check(TreeNode n) {
        Solution s = new Solution();
        List<List<Integer>> ret = s.zigzagLevelOrder(n);
        System.out.println(ret);
    }

}

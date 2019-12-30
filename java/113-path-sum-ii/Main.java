// start    2019-12-29 21:19:22
// finish   2019-12-29 21:38:06

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
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        return iterative(root, sum);
        //return recursive(root, sum);
    }

    List<List<Integer>> iterative(TreeNode root, int sum) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        int pathSum = 0;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root, prev = root;
        while ( curr != null || !stack.empty() ) {
            while ( curr != null ) {
                stack.push(curr);
                pathSum += curr.val;
                path.add(curr.val);
                curr = curr.left;
            }
            curr = stack.peek();
            if ( curr.right != null && curr.right != prev ) {
                curr = curr.right;
                continue;
            }
            if ( curr.left == null && curr.right == null && pathSum == sum ) {
                list.add(new ArrayList<>(path));
            }
            stack.pop();
            path.remove(path.size()-1);
            pathSum -= curr.val;
            prev = curr;
            curr = null;
        }
        return list;
    }

    List<List<Integer>> recursive(TreeNode root, int sum) {
        List<List<Integer>> list = new ArrayList<>();
        dfs(root, sum, new ArrayList<>(), list);
        return list;
    }

    void dfs(TreeNode n, int remain, List<Integer> l, List<List<Integer>> list) {
        if ( n == null ) return;
        l.add(n.val);
        remain -= n.val;
        if ( n.left == null && n.right == null && remain == 0 ) {
            list.add(new ArrayList<>(l));
        } else {
            dfs(n.left, remain, l, list);
            dfs(n.right, remain, l, list);
        }
        l.remove(l.size()-1);
    }
}

public class Main {
    public static void main(String[] args) {
        TreeNode n;
        n = Gardener.grow(new Integer[] {});
        check(n, 1);
        n = Gardener.grow(new Integer[] {1,2,3,4,5});
        check(n, 8);
        n = Gardener.grow(new Integer[] {5,4,8,11,null,13,4,7,2,null,null,5,1});
        check(n, 22);
    }

    static void check(TreeNode n, int sum) {
        Solution s = new Solution();
        List<List<Integer>> ret = s.pathSum(n, sum);
        System.out.println(ret);
    }

}

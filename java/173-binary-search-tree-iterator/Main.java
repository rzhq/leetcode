// start    2019-12-31 15:03:41
// finish   2019-12-31 15:40:33

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
class BSTIterator {

    Stack<TreeNode> stack;
    public BSTIterator(TreeNode root) {
        stack = new Stack<>();
        while ( root != null ) {
            stack.push(root);
            root = root.left;
        }
    }
    
    /** @return the next smallest number */
    public Integer next() {
        TreeNode n = stack.pop();
        int val = n.val;
        n = n.right;
        while ( n != null ) {
            stack.push(n);
            n = n.left;
        }
        return val;
    }
    
    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stack.empty();
    }
}

public class Main {
    public static void main(String[] args) {
        TreeNode n;
        n = Gardener.grow(new Integer[] {1,2,3,4,5});
        check(n);
    }

    static void check(TreeNode n) {
        Gardener.print(n);
        BSTIterator b = new BSTIterator(n);
        while ( b.hasNext() ) System.out.printf("%d ", b.next());
        System.out.printf("\n");
    }

}

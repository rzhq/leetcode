// start    2020-01-01 22:30:27
// finish   2020-01-01 22:44:43

import java.util.*;

/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
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
    ListNode node;
    public TreeNode sortedListToBST(ListNode head) {
        int i = 0;
        ListNode p = head;
        node = head;
        while ( p != null ) { p = p.next; i++; }
        return inorder(0, i-1);
    }

    TreeNode inorder(int low, int high) {
        if ( low > high ) return null;
        int mid = ( low + high ) / 2;
        TreeNode left = inorder(low, mid-1);
        TreeNode root = new TreeNode(node.val);
        node = node.next;
        root.left = left;
        root.right = inorder(mid+1, high);
        return root;
    }
}

public class Main {
    public static void main(String[] args) {
        ListNode node;
        node = Connector.connect(new Integer[] {1});
        check(node);
        node = Connector.connect(new Integer[] {1,2});
        check(node);
        node = Connector.connect(new Integer[] {1,2,3});
        check(node);
        node = Connector.connect(new Integer[] {1,2,3,4,5,6,7});
        check(node);
        node = Connector.connect(new Integer[] {1,2,3,4,5,6,7,8});
        check(node);
        node = Connector.connect(new Integer[] {1,2,3,4,5,6,7,8,9});
        check(node);
    }
    
    static void check(ListNode node) {
        Solution s = new Solution();
        TreeNode n = s.sortedListToBST(node);
        Gardener.print(n);
    }
}

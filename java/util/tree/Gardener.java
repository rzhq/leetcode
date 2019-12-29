import java.util.*;

class Gardener {
    public static TreeNode grow(Integer[] input) {
        int n = input.length;
        TreeNode[] nodes = new TreeNode[n];
        if ( input == null || input.length < 1 || input[0] == null ) return null;
        nodes[0] = new TreeNode(input[0]);
        int p = 0, q = 1, i = 1;
        while ( i < n ) {
            while ( p < n && nodes[p] == null ) p++;
            nodes[p].left = input[i] == null ? null : new TreeNode(input[i]);
            nodes[q++] = nodes[p].left;
            i++;
            if ( i >= n ) break;
            nodes[p].right = input[i] == null ? null : new TreeNode(input[i]);
            nodes[q++] = nodes[p].right;
            i++;
            p++;
        }
        return nodes[0];
    }
}

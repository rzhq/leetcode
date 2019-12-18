// start  2019-12-18 12:20:44
// finish 2019-12-18 12:52:28

import java.util.*;

class Solution {
    public boolean exist(char[][] board, String word) {
        if ( board.length < 1 || board[0].length < 1 ) return false;
        int m = board.length, n = board[0].length;
        boolean[][] used = new boolean[m][n];
        for ( int i = 0; i < m; i++ ) {
            for ( int j = 0; j < n; j++ ) {
                if ( find(board, used, i, j, word, 0 ) ) return true;
            }
        }
        return false;
    }

    boolean find(char[][] board, boolean[][] used, int i, int j, String word, int k) {
        if ( i < 0 || i >= board.length ) return false;
        if ( j < 0 || j >= board[0].length ) return false;
        if ( k >= word.length() ) return true;
        if ( used[i][j] || board[i][j] != word.charAt(k)) return false;
        used[i][j] = true;
        if ( find(board, used, i+1, j, word, k+1) ||
            find(board, used, i, j+1, word, k+1) ||
            find(board, used, i-1, j, word, k+1) ||
            find(board, used, i, j-1, word, k+1) ) {
            return true;
        }
        used[i][j] = false;
        return false;
    }
}

public class Main {
    public static void main(String[] args) {
        char[][] input;
        input = new char[][] {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        check(input, "ABCCED", true);
        check(input, "SEE", true);
        check(input, "ABCB", false);
    }
    
    static void check(char[][] input, String word, boolean out) {
        Solution s = new Solution();
        boolean ret = s.exist(input, word);
        System.out.printf("%s %s\n", ret, out);
    }
}


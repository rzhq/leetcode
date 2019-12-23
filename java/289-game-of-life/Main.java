// start    2019-12-23 15:23:53
// finish   2019-12-23 15:48:56

import java.util.*;

class Solution {
    public void gameOfLife(int[][] board) {
        if ( board.length < 1 || board[0].length < 1 ) return;
        for ( int i = 0; i < board.length; i++ ) {
            for ( int j = 0; j < board[0].length; j++ ) {
                check(board, i, j);
            }
        }
        for ( int i = 0; i < board.length; i++ ) {
            for ( int j = 0; j < board[0].length; j++ ) {
                board[i][j] >>= 1;
            }
        }
    }
    
    void check(int[][] b, int i, int j) {
        int c = 0;
        for ( int ii = Math.max(i-1, 0); ii <= Math.min(i+1, b.length-1); ii++ ) {
            for ( int jj = Math.max(j-1, 0); jj <= Math.min(j+1, b[0].length-1); jj++ ) {
                if ( ii == i && jj == j ) continue;
                c += b[ii][jj] & 1;
            }
        }
        if ( c == 3 ) b[i][j] |= 2;
        else if ( b[i][j] % 2 == 1 && c == 2 ) b[i][j] |= 2;
    }
}

public class Main {
    public static void main(String[] args) {
        int[][] input;
        input = new int[][] {
          {0,1,0},
          {0,0,1},
          {1,1,1},
          {0,0,0}
        };
        String out = "[[0, 0, 0], [1, 0, 1], [0, 1, 1], [0, 1, 0]]";
        check(input, out);
    }
    
    static void check(int[][] input, String out) {
        Solution s = new Solution();
        s.gameOfLife(input);
        System.out.println(Arrays.deepToString(input));
        System.out.printf("%s\n", out);
    }
}


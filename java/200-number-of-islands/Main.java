import java.util.*;

class Solution {
    int m, n;
    char[][] map;

    public int numIslands(char[][] grid) {
        int counter = 0;
        m = grid.length;
        if (m == 0) return 0;
        n = grid[0].length;
        map = grid;
        for (int i = 0; i < m; i += 1) {
            for (int j = 0; j < n; j+= 1) {
                if (map[i][j] == '1') {
                    DFSMarking(i, j);
                    counter += 1;
                }
            }
        }
        return counter;
    }

    public void DFSMarking(int i, int j) {
        if (i < 0 || j < 0 || i >= m || j >= n || map[i][j] != '1') return;
        map[i][j] = '#';
        DFSMarking(i-1, j);
        DFSMarking(i+1, j);
        DFSMarking(i, j-1);
        DFSMarking(i, j+1);
    }
}

public class Main {
    public static void main(String[] args) {
        char[][] input;
        input = new char[][] {
  {'1','1','1','1','0'},
  {'1','1','0','1','0'},
  {'1','1','0','0','0'},
  {'0','0','0','0','0'}
};
        check(input);
        input = new char[][] {
  {'1','1','0','0','0'},
  {'1','1','0','0','0'},
  {'0','0','1','0','0'},
  {'0','0','0','1','1'}
};
        check(input);
    }

    
    static void check(char[][] input) {
        Solution s = new Solution();
        System.out.printf("%d\n", s.numIslands(input));
    }
}


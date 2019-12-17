// start  2019-12-17 15:37:40
// finish 2019-12-17 16:33:39

import java.util.*;

class Solution {
    public void setZeroes(int[][] matrix) {
        if ( matrix.length < 1 ) return;
        if ( matrix[0].length < 1 ) return;
        boolean zr = false, zc = false;
        for ( int i = 0; i < matrix.length; i++ ) {
            for ( int j = 0; j < matrix[0].length; j++ ) {
                if ( matrix[i][j] == 0 ) {
                    if ( i != 0 && j != 0 ) {
                        matrix[0][j] = 0;
                        matrix[i][0] = 0;
                    } else {
                        if ( i == 0 ) zr = true;
                        if ( j == 0 ) zc = true;
                    }
                }
            }
        }
        for ( int i = 1; i < matrix.length; i++ ) {
            for ( int j = 1; j < matrix[0].length; j++ ) {
                if ( matrix[0][j] == 0 || matrix[i][0] == 0 ) {
                    matrix[i][j] = 0;
                }
            }
        }
        if ( zc ) {
            for ( int i = 0; i < matrix.length; i++ ) {
                matrix[i][0] = 0;
            }
        }
        if ( zr ) {
            for ( int i = 0; i < matrix[0].length; i++ ) {
                matrix[0][i] = 0;
            }
        }
    }

    public void setZeroesMpN(int[][] matrix) {
        if ( matrix.length < 1 ) return;
        boolean[] mz = new boolean[matrix.length];
        boolean[] nz = new boolean[matrix[0].length];
        for ( int i = 0; i < matrix.length; i++ ) {
            for ( int j = 0; j < matrix[0].length; j++ ) {
                if ( matrix[i][j] == 0 ) {
                    mz[i] = true;
                    nz[j] = true;
                }
            }
        }
        for ( int i = 0; i < matrix.length; i++ ) {
            for ( int j = 0; j < matrix[0].length; j++ ) {
                if ( mz[i] || nz[j] ) matrix[i][j] = 0;
            }
        }
    }
}

public class Main {
    public static void main(String[] args) {
        int[] input;
        input = new int[] {};
        check(input);
    }
    
    static void check(int[] input) {
        Solution s = new Solution();
        System.out.printf("\n");
    }
}


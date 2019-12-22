// start    2019-12-22 14:17:31
// finish   2019-12-22 14:27:07

import java.util.*;

class Solution {
    public int findMin(int[] A) {
        if ( A.length < 1 ) return 0;
        if ( A.length < 2 ) return A[0];
        int l = 0, h = A.length - 1, m;
        while ( l < h ) {
            m = ( l + h ) / 2;
            if ( A[m] > A[h] ) l = m + 1;
            else h = m;
        }
        return A[l];
    }
}

public class Main {
    public static void main(String[] args) {
        int[] input;
        input = new int[] {1,2,3,4,5};
        check(input, 1);
        input = new int[] {3,4,5,6,0,1,2};
        check(input, 0);
        input = new int[] {1,2,3,4,5,0};
        check(input, 0);
        input = new int[] {5,6,0,1,2,3,4};
        check(input, 0);
    }
    
    static void check(int[] input, int out) {
        Solution s = new Solution();
        int ret = s.findMin(input);
        System.out.printf("%d %d\n", ret, out);
    }
}


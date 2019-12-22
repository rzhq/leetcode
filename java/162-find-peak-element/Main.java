// start    2019-12-22 14:36:27
// finish   2019-12-22 15:05:56

import java.util.*;

class Solution {
    public int findPeakElement(int[] A) {
        if ( A.length < 2 ) return 0;
        int l = 0, h = A.length - 1, m;
        while ( l < h ) {
            m = ( l + h ) / 2;
            if ( A[m] < A[m+1] ) l = m + 1;
            else h = m;
        }
        return l;
    }

    public int findPeakElementR(int[] A) {
        if ( A.length == 1 || A[0] > A[1] ) return 0;
        if ( A[A.length-1] > A[A.length-2] ) return A.length-1;
        int l = 1, h = A.length - 2, m;
        while ( l < h ) {
            m = ( l + h ) / 2;
            if ( A[m] < A[m-1] ) h = m - 1;
            else if ( A[m] < A[m+1] ) l = m + 1;
            else return m;
        }
        return l;
    }
}

public class Main {
    public static void main(String[] args) {
        int[] input;
        input = new int[] {1,2,3,1};
        check(input, 2);
        input = new int[] {1,2,3,1,2,3,4,5,6,5,4};
        check(input, 8);
    }
    
    static void check(int[] input, int out) {
        Solution s = new Solution();
        int ret = s.findPeakElement(input);
        System.out.printf("%d %d\n", ret, out);
    }
}


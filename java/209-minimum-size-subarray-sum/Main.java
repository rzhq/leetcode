// start    2019-12-22 15:58:38
// finish   2019-12-22 16:41:34

import java.util.*;

class Solution {
    public int minSubArrayLen(int s, int[] A) {
        if ( A.length < 1 ) return 0;
        int sum = 0;
        int i = 0, j = 0, min = A.length + 1;
        while ( j < A.length ) {
            sum += A[j++];
            while ( sum >= s ) {
                min = Math.min(min, j - i);
                sum -= A[i++];
            }
        }
        return min == A.length + 1 ? 0 : min;
    }
}

public class Main {
    public static void main(String[] args) {
        int[] input;
        input = new int[] {2,3,1,2,4,3};
        check(input, 7, 2);
    }
    
    static void check(int[] input, int t, int out) {
        Solution s = new Solution();
        int ret = s.minSubArrayLen(t, input);
        System.out.printf("%d %d\n", ret, out);
    }
}


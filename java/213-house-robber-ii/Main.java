// start    2020-01-10 20:56:24
// finish   2020-01-10 21:25:45

import java.util.*;

class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if ( n < 1 ) return 0;
        if ( n == 1 ) return nums[0];
        return Math.max(rob(nums, 0, n-1), rob(nums, 1, n));
    }

    int rob(int[] nums, int low, int high) {
        int prev = 0, pprev = 0;
        for ( int i = low; i < high; ++i) {
            int max = Math.max(pprev + nums[i], prev);
            pprev = prev;
            prev = max;
        }
        return prev;
    }
}

public class Main {
    public static void main(String[] args) {
        int[] input;
        input = new int[] {2};
        check(input, 2);
        input = new int[] {2,3,2};
        check(input, 3);
        input = new int[] {1,2,3,1};
        check(input, 4);
    }
    
    static void check(int[] input, int out) {
        Solution s = new Solution();
        int ret = s.rob(input);
        System.out.printf("%d %d\n", ret, out);
    }
}


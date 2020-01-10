// start    2020-01-10 19:04:29
// finish   2020-01-10 19:21:48

import java.util.*;

class Solution {
    public int rob(int[] nums) {
        return CSpace(nums);
    }

    int CSpace(int[] nums) {
        int prev = 0, pprev = 0;
        for ( int n : nums ) {
            int max = Math.max(pprev + n, prev);
            pprev = prev;
            prev = max;
        }
        return prev;
    }

    int NSpace(int[] nums) {
        int n = nums.length;
        if ( n < 1 ) return 0;
        if ( n == 1 ) return nums[0];

        int[] profit = new int[n];
        profit[0] = nums[0];
        profit[1] = Math.max(nums[0], nums[1]);
        for ( int i = 2; i < n; ++i ) {
            profit[i] = Math.max(profit[i-1], profit[i-2] + nums[i]);
        }
        return profit[n-1];
    }
}

public class Main {
    public static void main(String[] args) {
        int[] input;
        input = new int[] {1,2,3,1};
        check(input, 4);
        input = new int[] {2,7,9,3,1};
        check(input, 12);
        input = new int[] {2,1,1,2};
        check(input, 4);
    }
    
    static void check(int[] input, int out) {
        Solution s = new Solution();
        int ret = s.rob(input);
        System.out.printf("%d %d\n", ret, out);
    }
}


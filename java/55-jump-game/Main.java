// start  2019-12-16 18:47:43
// finish 2019-12-16 19:02:32

import java.util.*;

class Solution {
    public boolean canJump(int[] nums) {
        if ( nums.length < 1 ) return false;
        int m = 0;
        for ( int i = 0; i <= m; i++ ) {
            m = Math.max(i + nums[i], m);
            if ( m >= nums.length - 1 ) return true;
        }
        return false;
    }
}

public class Main {
    public static void main(String[] args) {
        int[] input;
        input = new int[] {2,3,1,1,4};
        check(input, true);
        input = new int[] {3,2,1,0,5};
        check(input, false);
        input = new int[] {};
        check(input, false);
        input = new int[] {1};
        check(input, true);
        input = new int[] {1,2};
        check(input, true);
        input = new int[] {3,0,8,2,0,0,1};
        check(input, true);
    }
    
    static void check(int[] input, boolean out) {
        Solution s = new Solution();
        boolean ret = s.canJump(input);
        System.out.printf("%s %s\n", ret, out);
    }
}


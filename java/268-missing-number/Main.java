// start  2019-12-11 16:58:10
// finish 2019-12-11 17:03:14

import java.util.*;

class Solution {
    public int missingNumber(int[] nums) {
        int sum = ( 1 + nums.length ) * nums.length / 2;
        for ( int n : nums ) { sum -= n; }
        return sum;
    }
}

public class Main {
    public static void main(String[] args) {
        int[] input;
        input = new int[] {3,0,1};
        check(input);
        input = new int[] {3,0,1,2,4,6,7,8};
        check(input);
    }
    
    static void check(int[] input) {
        Solution s = new Solution();
        int ret = s.missingNumber(input);
        System.out.println(ret);
    }
}


// start  2019-12-11 16:07:18
// finish 2019-12-11 16:27:45

import java.util.*;

class Solution {
    public void rotate(int[] nums, int k) {
        if ( nums.length < 2 ) return;
        int[] tmp = new int[nums.length];
        k = k % nums.length;
        for ( int i = 0; i < nums.length; i++ ) {
            if ( i - k >= 0 ) {
                tmp[i] = nums[i-k];
            } else {
                tmp[i] = nums[i-k+nums.length];
            }
        }
        for ( int i = 0; i < tmp.length; i++ ) { nums[i] = tmp[i]; }
    }
}

public class Main {
    public static void main(String[] args) {
        int[] input;
        input = new int[] {1,2,3,4,5,6,7};
        check(input, 1);
        input = new int[] {1,2,3,4,5,6,7};
        check(input, 2);
        input = new int[] {1,2,3,4,5,6,7};
        check(input, 3);
        input = new int[] {1,2,3,4,5,6,7};
        check(input, 8);
        input = new int[] {1};
        check(input, 3);
        input = new int[] {1,2};
        check(input, 3);
    }
    
    static void check(int[] input, int k) {
        Solution s = new Solution();
        s.rotate(input, k);
        System.out.println(Arrays.toString(input));
    }
}


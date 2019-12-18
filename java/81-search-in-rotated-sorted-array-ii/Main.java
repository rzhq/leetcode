// start  2019-12-18 16:15:01
// finish 2019-12-18 17:22:03

import java.util.*;

class Solution {
    public boolean search(int[] nums, int target) {
        if ( nums.length < 1 ) return false;
        if ( nums.length == 1 ) return target == nums[0];
        int l = 0, r = nums.length - 1, m;
        while ( l <= r ) {
            m = ( l + r ) / 2;
            if ( nums[m] == target ) return true;
            if ( nums[l] == nums[m] && nums[m] == nums[r] ) {
                l++; r--;
            } else if ( nums[l] <= nums[m] ) {
                if ( nums[l] <= target && target < nums[m] ) r = m - 1;
                else l = m + 1;
            } else {
                if ( nums[m] < target && target <= nums[r] ) l = m + 1;
                else r = m - 1;
            }
        }
        return false;
    }
}

public class Main {
    public static void main(String[] args) {
        int[] input;
        input = new int[] {3,4,5,6,7,1,2};
        check(input, 4, true);
        input = new int[] {4,5,6,7,1,2,3};
        check(input, 1, true);
        input = new int[] {4,5,6,7,1,2,3};
        check(input, 4, true);
        input = new int[] {3,5,6,7,1,2};
        check(input, 4, false);
        input = new int[] {3,5,5,5,5,6,7,1,2,2,2,2,2,2,2,2};
        check(input, 4, false);
        input = new int[] {5,5,6,7,1,2,3,4,5,5,5,5,5};
        check(input, 6, true);
        input = new int[] {2,5,6,0,0,1,2};
        check(input, 0, true);
        input = new int[] {2,5,6,0,0,1,2};
        check(input, 3, false);
        input = new int[] {2,2,2,2,2,2};
        check(input, 3, false);
        input = new int[] {2,2,2,0,2,2};
        check(input, 0, true);
        input = new int[] {2,2,2,2,0,2,2};
        check(input, 0, true);
        input = new int[] {2,2,2,0};
        check(input, 0, true);
    }
    
    static void check(int[] input, int target, boolean out) {
        Solution s = new Solution();
        boolean ret = s.search(input, target);
        System.out.printf("%s %s\n", ret, out);
    }
}


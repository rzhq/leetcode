// start  2019-12-11 16:39:22
// finish 2019-12-11 16:48:45

import java.util.*;

class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for ( int i = 0; i < nums.length; i++ ) {
            if ( map.containsKey(nums[i]) && i - map.get(nums[i]) <= k ) {
                    return true;
            } else {
                map.put(nums[i], i);
            }
        }
        return false;
    }
}

public class Main {
    public static void main(String[] args) {
        int[] input;
        input = new int[] {1,2,3,1};
        check(input, 3);
        input = new int[] {1,0,1,1};
        check(input, 1);
        input = new int[] {1,2,3,1,2,3};
        check(input, 2);
        input = new int[] {};
        check(input, 2);
    }
    
    static void check(int[] input, int k) {
        Solution s = new Solution();
        boolean ret = s.containsNearbyDuplicate(input, k);
        System.out.println(ret);
    }
}


// start  2019-12-11 17:03:52
// finish 2019-12-11 17:36:08

import java.util.*;

class Solution {
    public void moveZeroes(int[] nums) {
        int z = 0;
        int nz;
        while ( z < nums.length && nums[z] != 0 ) { z++; }
        nz = z;
        while ( nz < nums.length && nums[nz] == 0 ) { nz++; }
        while ( z < nums.length && nz < nums.length ) {
            nums[z] = nums[nz];
            nums[nz] = 0;
            while ( z < nums.length && nums[z] != 0 ) { z++; }
            while ( nz < nums.length && nums[nz] == 0 ) { nz++; }
        }
    }
}

public class Main {
    public static void main(String[] args) {
        int[] input;
        input = new int[] {0,1,0,3,12};
        check(input);
        input = new int[] {1,0,2,3,12};
        check(input);
        input = new int[] {1,0,0,0,0,2,3,12,0,0};
        check(input);
    }
    
    static void check(int[] input) {
        Solution s = new Solution();
        s.moveZeroes(input);
        System.out.println(Arrays.toString(input));
    }
}


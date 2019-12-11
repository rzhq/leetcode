// start  2019-12-11 16:28:25
// finish 2019-12-11 16:38:23

import java.util.*;

class Solution {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for ( int n : nums ) {
            if ( set.contains(n) ) {
                return true;
            } else {
                set.add(n);
            }
        }
        return false;
    }
}

public class Main {
    public static void main(String[] args) {
        int[] input;
        input = new int[] {1,2,3};
        check(input);
        input = new int[] {1,2,1};
        check(input);
    }
    
    static void check(int[] input) {
        Solution s = new Solution();
        boolean ret = s.containsDuplicate(input);
        System.out.println(ret);
    }
}


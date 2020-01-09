// start    2020-01-09 15:26:02
// finish   2020-01-09 15:37:49

import java.util.*;

class Solution {
    public int singleNumber(int[] nums) {
        return CSpace(nums);
    }

    public int CSpace(int[] nums) {
        int ret = 0;
        for ( int n : nums ) {
            ret ^= n;
        }
        return ret;
    }

    public int NSpace(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for ( int n : nums ) {
            if ( map.containsKey(n) ) {
                map.put(n, map.get(n)+1);
            } else {
                map.put(n, 1);
            }
        }
        for ( Integer k : map.keySet() ) {
            if ( map.get(k) == 1 ) return k;
        }
        return 0;
    }
}

public class Main {
    public static void main(String[] args) {
        int[] input;
        input = new int[]{1,2,2,3,4,3,4};
        check(input, 1);
    }
    
    static void check(int[] input, int out) {
        Solution s = new Solution();
        int ret = s.singleNumber(input);
        System.out.printf("%d %d\n", ret, out);
    }
}


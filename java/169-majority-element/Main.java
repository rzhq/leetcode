// start  2019-12-11 15:33:06
// finish 2019-12-11 16:04:28

import java.util.*;

class Solution {
    public int majorityElement(int[] A) {
        if ( A.length < 1 ) return 0;
        int m = A[0], c = 1;
        for ( int i = 1; i < A.length; i++ ) {
            if ( m == A[i] ) {
                c++;
            } else {
                if ( c == 0 ) {
                    m = A[i];
                    c++;
                } else {
                    c--;
                }
            }
        }
        return m;
    }

    public int majorityElementMap(int[] nums) {
        int num = nums[0];
        int max = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for ( int n : nums ) {
            if ( map.get(n) == null ) {
                map.put(n, 1);
            } else {
                map.put(n, map.get(n)+1);
            }
        }
        for ( Map.Entry me : map.entrySet() ) {
            if ( (int) me.getValue() > max ) {
                num = (int) me.getKey();
                max = (int) me.getValue();
            }
        }
        return num;
    }
}

public class Main {
    public static void main(String[] args) {
        int[] input;
        input = new int[] {1};
        check(input);
        input = new int[] {1,2,2};
        check(input);
        input = new int[] {1,2,2,3,2,3,2,3,2};
        check(input);
    }
    
    static void check(int[] input) {
        Solution s = new Solution();
        int ret = s.majorityElement(input);
        System.out.println(ret);
    }
}


// start  2019-12-11 15:06:31
// finish 2019-12-11 15:24:37

import java.util.*;

class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int i = 0;
        int j = numbers.length - 1;
        int sum;
        while ( i < j ) {
            sum = numbers[i] + numbers[j];
            if ( sum > target ) {
                j--;
            } else if ( sum < target ) {
                i++;
            } else {
                return new int[] { i+1, j+1 };
            }
        }
        return new int[] {};
    }

    public int[] twoSumMap(int[] numbers, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int req;
        for ( int i = 0; i < numbers.length; i++ ) {
            req = target - numbers[i];  
            if ( map.get(req) != null ) {
                return new int[] { map.get(req)+1, i+1 };
            }
            map.put(numbers[i], i);
        }
        return new int[] {};
    }
}

public class Main {
    public static void main(String[] args) {
        int[] input;
        input = new int[] {2,7,11,15};
        check(input, 9);
        input = new int[] {2,7,11,15};
        check(input, 22);
    }
    
    static void check(int[] input, int target) {
        Solution s = new Solution();
        int[] ret = s.twoSum(input, target);
        System.out.println(Arrays.toString(ret));
    }
}


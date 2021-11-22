import java.util.*;

class Solution {
    public int singleNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            int val = map.getOrDefault(num, 0);
            map.put(num, val+1);
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) return entry.getKey();
        }
        return -1;
    }
}

public class Main {
    public static void main(String[] args) {
        int[] input;
        input = new int[] {1,2,1,2,1,2,3};
        check(input, 3);
    }
    
    static void check(int[] input, int exp) {
        Solution s = new Solution();
        int res = s.singleNumber(input);
        System.out.printf("%d %d\n", exp, res);
    }
}


import java.util.*;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i+=1) {
            map.put(target - nums[i], i);
        }
        for (int i = 0; i < nums.length; i+=1) {
            Integer j = map.get(nums[i]);
            if (j != null && i != j) {
                return new int[] { i, j };
            }
        }
        return new int[] {};
    }
}

public class TwoSum {
    public static void main(String[] args) {
        int[] arg = { 1, 2, 3, 4 };
        Solution s = new Solution();
        int[] r = s.twoSum(arg, 6);
        System.out.println(Arrays.toString(r));
    }
}


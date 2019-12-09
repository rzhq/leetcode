import java.util.*;

class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int res = nums[0] + nums[1] + nums[nums.length-1];
        int sum;
        for (int i = 0; i < nums.length-2; i++) {
            int j = i + 1;
            int k = nums.length - 1;
            while (j < k) {
                sum = nums[i] + nums[j] + nums[k];
                if (sum == target) {
                    return sum;
                } else if (sum < target) {
                    j++;
                } else if (sum > target) {
                    k--;
                }
                if (Math.abs(target - sum) < Math.abs(target - res)) {
                    res = sum;
                }
            }
        }
        return res;
    }
}

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        int r = s.threeSumClosest(new int[] {-1, 2, 1, -4}, 1);
        System.out.println(r);
    }
}


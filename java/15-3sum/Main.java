import java.util.*;

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        if (nums.length < 3) return new ArrayList<List<Integer>> ();
        Arrays.sort(nums);
        int target = 0;
        HashSet<List<Integer>> listSet = new HashSet<List<Integer>> ();
        for (int i = 0; i < nums.length-2; i++) {
            int j = i + 1;
            int k = nums.length - 1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum == target) {
                    listSet.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    j += 1;
                    k -= 1;
                } else if (sum > target) {
                    k -= 1;
                } else {
                    j += 1;
                }
            }
        }
        return new ArrayList<List<Integer>> (listSet);
    }
}

public class Main {
    public static void main(String[] args) {
        int[] input = {-1, 0, 1, 2, -1, -4};
        Solution s = new Solution();
        List<List<Integer>> r = s.threeSum(input);
        // System.out.println(Arrays.deepToString(r));
        System.out.println(r);
    }
}


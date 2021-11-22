import java.util.*;

class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int max = 0;
        for (int num : nums) {
            if (set.contains(num-1)) continue;

            int seq = 1;
            int n = num + 1;
            while (set.contains(n)) {
                seq += 1;
                n += 1;
            }
            max = Math.max(max, seq);
        }
        return max;
    }
}

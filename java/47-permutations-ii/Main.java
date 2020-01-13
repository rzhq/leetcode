// start    2020-01-13 22:42:25
// finish   2020-01-13 23:03:21

import java.util.*;

class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        Arrays.sort(nums);
        dfs(nums, used, new ArrayList<>(), list);
        return list;
    }

    void dfs(int[] nums, boolean[] used, List<Integer> l, List<List<Integer>> list) {
        if ( nums.length == l.size() ) {
            list.add(new ArrayList<>(l));
            return;
        }
        for ( int i = 0; i < nums.length; ++i ) {
            if ( used[i] ) continue;
            if ( i > 0 && nums[i-1] == nums[i] && !used[i-1] ) continue;
            used[i] = true;
            l.add(nums[i]);
            dfs(nums, used, l, list);
            l.remove(l.size()-1);
            used[i] = false;
        }
    }
}

public class Main {
    public static void main(String[] args) {
        int[] input;
        input = new int[] {1,1,2};
        check(input);
    }
    
    static void check(int[] input) {
        Solution s = new Solution();
        List<List<Integer>> ret = s.permuteUnique(input);
        System.out.printf("%s\n", ret);
    }
}


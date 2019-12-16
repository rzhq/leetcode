// start  2019-12-16 13:29:07
// finish 2019-12-16 14:13:27

import java.util.*;

class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(candidates);
        find(candidates, 0, target, new ArrayList<>(), list);
        return list;
    }

    void find(int[] can, int i, int target, List<Integer> l, List<List<Integer>> list) {
        if ( target < 0 ) return;
        if ( target == 0 ) list.add(new ArrayList<>(l));
        for ( int j = i; j < can.length; j++ ) {
            l.add(can[j]);
            find(can, j, target - can[j], l, list);
            l.remove(l.size()-1);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        int[] input;
        input = new int[] {2,3,4,5};
        check(input, 8);
    }
    
    static void check(int[] input, int target) {
        Solution s = new Solution();
        List<List<Integer>> list = s.combinationSum(input, target); 
        System.out.println(list);
    }
}


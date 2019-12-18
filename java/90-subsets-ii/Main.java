// start  2019-12-18 17:23:03
// finish 2019-12-18 17:37:46

import java.util.*;

class Solution {
    public List<List<Integer>> subsetsWithDup(int[] A) {
        List<List<Integer>> list = new ArrayList<>();
        if ( A.length < 1 ) return list;
        Arrays.sort(A);
        dfs(A, 0, new ArrayList<>(), list);
        return list;
    }

    void dfs(int[] A, int i, List<Integer> l, List<List<Integer>> list) {
        list.add(new ArrayList<>(l));
        for ( int j = i; j < A.length; j++ ) {
            if ( j > i && A[j] == A[j-1] ) continue;
            l.add(A[j]);
            dfs(A, j+1, l, list);
            l.remove(l.size() - 1);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        int[] input;
        input = new int[] {};
        check(input);
        input = new int[] {1};
        check(input);
        input = new int[] {1,2,2};
        check(input);
        input = new int[] {1,2,2,3,4,5};
        check(input);
    }
    
    static void check(int[] input) {
        Solution s = new Solution();
        List<List<Integer>> ret = s.subsetsWithDup(input);
        System.out.println(ret);
    }
}


// start    2020-01-14 17:55:02
// finish   2020-01-14 18:09:51

import java.util.*;

class Solution {
    public List<Integer> grayCode(int n) {
        List<Integer> res = new ArrayList<>();
        res.add(0);
        for ( int i = 0; i < n; ++i ) {
            int size = res.size();
            for ( int j = size-1; j >= 0; --j ) {
                res.add(res.get(j) | 1<<i);
            }
        }
        return res;
    }
}

public class Main {
    public static void main(String[] args) {
        check(2);
        check(3);
    }
    
    static void check(int x) {
        Solution s = new Solution();
        List<Integer> ret = s.grayCode(x);
        System.out.printf("%s\n", ret);
    }
}


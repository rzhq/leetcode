// start    2020-01-07 09:31:58
// finish   2020-01-07 10:19:50

import java.util.*;

class Solution {
    public String getPermutation(int n, int k) {
        List<Integer> list = new LinkedList<>();
        StringBuilder res = new StringBuilder();
        int w = 1;
        for ( int i = 1; i < n; i++ ) {
            list.add(i);
            w *= i;
        }
        list.add(n);
        
        k--;
        while ( !list.isEmpty() ) {
            res.append(list.remove(k / w));
            k %= w;
            w /= list.size() == 0 ? 1 : list.size();
        }
        return res.toString();
    }
}

public class Main {
    public static void main(String[] args) {
        check(3, 3, "213");
        check(4, 9, "2314");
    }
    
    static void check(int n, int k, String out) {
        Solution s = new Solution();
        String ret = s.getPermutation(n, k);
        System.out.printf("%s %s\n", ret, out);
    }
}


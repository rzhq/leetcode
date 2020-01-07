// start    2020-01-07 10:44:10
// finish   2020-01-07 11:42:12

import java.util.*;

class Solution {
    public String fractionToDecimal(int num, int den) {
        if ( num == 0 ) return "0";
        StringBuilder res = new StringBuilder();
        res.append((num > 0) ^ (den > 0) ? "-" : "");
        long n = Math.abs((long)num);
        long d = Math.abs((long)den);
        res.append(n / d);
        long r = n % d;
        if ( r == 0 ) return res.toString();

        res.append(".");
        HashMap<Long, Integer> map = new HashMap<>();
        map.put(r, res.length());
        while ( r != 0 ) {
            n = r * 10;
            res.append(n / d);
            r = n % d;
            if ( map.containsKey(r) ) {
                res.insert(map.get(r), "(");
                res.append(")");
                break;
            } else {
                map.put(r, res.length());
            }
        }
        return res.toString();
    }
}

public class Main {
    public static void main(String[] args) {
        check(1, 2);
        check(-22, 1);
        check(0, 1);
        check(-2, 3);
        check(11, 100);
        check(-1, 7);
    }
    
    static void check(int n, int d) {
        Solution s = new Solution();
        String ret = s.fractionToDecimal(n, d);
        System.out.printf("%s %.10f\n", ret, 1. * n / d);
    }
}


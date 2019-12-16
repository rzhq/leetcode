// start  2019-12-16 10:38:54
// finish 2019-12-16 11:09:48

import java.util.*;

class Solution {
    public int countPrimes(int n) {
        int c = 0;
        boolean[] notPrime = new boolean[n];
        for ( int i = 2; i * i < n; i++ ) {
            if ( !notPrime[i] ) {
                for ( int j = 2; i * j < n; j++ ) {
                    notPrime[i*j] = true;
                }
            }
        }
        for ( int i = 2; i < n; i++ ) {
            if ( !notPrime[i] ) c++;
        }
        return c;
    }
}

public class Main {
    public static void main(String[] args) {
        check(1, 0);
        check(2, 0);
        check(10, 4);
        check(20, 8);
        check(30, 10);
    }
    
    static void check(int x, int out) {
        Solution s = new Solution();
        int ret = s.countPrimes(x);
        System.out.printf("%d %d\n", ret, out);
    }
}


// start  2019-12-16 11:22:05
// finish 2019-12-16 11:32:45

import java.util.*;

class Solution {
    public int addDigits(int num) {
        return 1 + ( num - 1 ) % 9;
    }
}

public class Main {
    public static void main(String[] args) {
        check(0, 0);
        check(8, 8);
        check(9, 9);
        check(10, 1);
        check(123, 6);
        check(138, 3);
        check(345, 3);
    }
    
    static void check(int x, int out) {
        Solution s = new Solution();
        int ret = s.addDigits(x);
        System.out.printf("%d %d\n", ret, out);
    }
}


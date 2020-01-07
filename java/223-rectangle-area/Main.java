// start    2020-01-07 21:02:33
// finish   2020-01-07 21:19:09

import java.util.*;

class Solution {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int left = Math.max(A, E), right = Math.max(Math.min(C, G), left);
        int top = Math.min(D, H), bottom = Math.min(Math.max(B, F), top);
        return (C - A) * (D - B) + (G - E) * (H - F) - (right - left) * (top - bottom);
    }
}

public class Main {
    public static void main(String[] args) {
        check(-3, 0, 3, 4, 0, -1, 9, 2, 45);
        check(-2, -2, 2, 2, 3, 3, 4, 4, 17);
    }
    
    static void check(int A, int B, int C, int D, int E, int F, int G, int H, int out) {
        Solution s = new Solution();
        int ret = s.computeArea(A, B, C, D, E, F, G, H);
        System.out.printf("%d %d\n", ret, out);
    }
}


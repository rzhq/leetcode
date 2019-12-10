// start  19-12-10 15:46
// finish 19-12-10 16:18
import java.util.*;

class Solution {
    public int[] plusOne(int[] digits) {
        int c = 1;
        for ( int i = digits.length - 1; i >= 0; i-- ) {
            if ( c == 0 ) { break; }
            digits[i] += c;
            c = digits[i] / 10;
            digits[i] %= 10;
        }
        if ( c != 0 ) {
            int[] tmp = new int[digits.length+1];
            tmp[0] = c;
            for ( int i = 0; i < digits.length; i++ ) {
                tmp[i+1] = digits[i];
            }
            digits = tmp;
        }
        return digits;
    }
}

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] r;
        r = s.plusOne(new int[] {1,2,3});
        System.out.println(Arrays.toString(r));
        r = s.plusOne(new int[] {1,2,9});
        System.out.println(Arrays.toString(r));
        r = s.plusOne(new int[] {1,2,9,9});
        System.out.println(Arrays.toString(r));
        r = s.plusOne(new int[] {9,9,9});
        System.out.println(Arrays.toString(r));
        r = s.plusOne(new int[] {9});
        System.out.println(Arrays.toString(r));
    }
}


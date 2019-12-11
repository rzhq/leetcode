// start  2019-12-11 18:08:06
// finish 2019-12-11 18:30:58

import java.util.*;

class Solution {
    public int romanToInt(String s) {
        int sum = 0;
        for ( int i = 0; i < s.length(); i++ ) {
            switch ( s.charAt(i) ) {
                case 'I':
                    if ( i + 1 < s.length() &&
                        ( s.charAt(i+1) == 'V' || s.charAt(i+1) == 'X') )
                    {
                        sum -= 1;
                    } else {
                        sum += 1;
                    }
                    break;
                case 'X':
                    if ( i + 1 < s.length() &&
                        ( s.charAt(i+1) == 'L' || s.charAt(i+1) == 'C') )
                    {
                        sum -= 10;
                    } else {
                        sum += 10;
                    }
                    break;
                case 'C':
                    if ( i + 1 < s.length() &&
                        ( s.charAt(i+1) == 'D' || s.charAt(i+1) == 'M') )
                    {
                        sum -= 100;
                    } else {
                        sum += 100;
                    }
                    break;
                case 'V': sum += 5; break;
                case 'L': sum += 50; break;
                case 'D': sum += 500; break;
                case 'M': sum += 1000; break;
            }
        }
        return sum;
    }
}

public class Main {
    public static void main(String[] args) {
        String input;
        input = "III";
        check(input);
        input = "IV";
        check(input);
        input = "IX";
        check(input);
        input = "LVIII";
        check(input);
        input = "MCMXCIV";
        check(input);
    }
    
    static void check(String input) {
        Solution s = new Solution();
        int ret = s.romanToInt(input);
        System.out.println(ret);
    }
}


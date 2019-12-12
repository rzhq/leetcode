// start  2019-12-12 14:50:10
// finish 2019-12-12 16:03:42

import java.util.*;

class Solution {
    public String addBinary(String a, String b) {
        if ( a.equals("0") ) return b;
        if ( b.equals("0") ) return a;
        if ( a.length() < b.length() ) {
            String tmp = a;
            a = b;
            b = tmp;
        }
        int i = a.length() - 1, j = b.length() - 1;
        char[] sum = new char[i+1];
        int c = 0;
        while ( i >= 0 ) {
            int s = c + (int) a.charAt(i) - 48 + ( j>=0 ? (int) b.charAt(j) - 48 : 0 );
            c = s / 2;
            s %= 2;
            sum[i] = (char) ( s + 48 );
            i--; j--;
        }
        if ( c > 0 ) {
            char[] tmp = new char[sum.length+1];
            tmp[0] = (char) ( c + 48 );
            for ( int p=0; p<sum.length; p++ ) tmp[p+1] = sum[p];
            return String.valueOf(tmp);
        }
        return String.valueOf(sum);
    }

    public String addDecimal(String a, String b) {
        if ( a == "0" ) return b;
        if ( a == "0" ) return a;
        if ( a.length() < b.length() ) {
            String tmp = a;
            a = b;
            b = tmp;
        }
        int i = a.length() - 1, j = b.length() - 1;
        char[] sum = new char[i+2];
        int c = 0;
        while ( i >= 0 ) {
            int s = c + (int) a.charAt(i) - 48 + ( j>=0 ? (int) b.charAt(j) - 48 : 0 );
            c = s / 10;
            s %= 10;
            sum[i+1] = (char) ( s + 48 );
            i--; j--;
        }
        if ( c > 0 ) {
            char[] tmp = new char[sum.length+1];
            tmp[0] = (char) ( c + 48 );
            for ( int p=0; p<sum.length; p++ ) tmp[p+1] = sum[p];
            return String.valueOf(tmp);
        }
        return String.valueOf(sum);
    }
}

public class Main {
    public static void main(String[] args) {
        // check(123, 123);
        // check(999, 123);
        // check(1, 123);
        // check(19919, 123);
        // check(0, 1);
        // check(1, 1);
        // check(0, 0);
        // check(0, 0);
        check("1", "1", "10");
        check("0", "1", "1");
        check("0", "0", "0");
        check("10", "1", "11");
        check("111", "11", "1010");
    }

    static void check(String a, String b, String res) {
        Solution s = new Solution();
        String ret = s.addBinary(a, b);
        System.out.printf("%s %s\n", ret, res);
    }
    
    static void check(int a, int b) {
        Solution s = new Solution();
        String ret = s.addBinary(Integer.toString(a), Integer.toString(b));
        System.out.printf("%s %d\n", ret, a+b);
    }
}


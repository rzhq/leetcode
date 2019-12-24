// start    2019-12-24 16:50:38
// finish   2019-12-24 17:50:12

import java.util.*;

class Solution {
    public String reverseWords(String s) {
        if ( s == null || s.length() < 1 ) return "";
        char[] c = s.toCharArray();
        int n = s.length();
        reverse(c, 0, n);

        int i = 0, j = 0;
        while ( j < n ) {
            while ( i < n && c[i] == ' ' ) i++;
            j = i;
            while ( j < n && c[j] != ' ' ) j++;
            reverse(c, i, j);
            i = j;
        }

        i = j = 0;
        while ( j < n ) {
            while ( j < n && c[j] == ' ') j++;
            while ( j < n && c[j] != ' ') c[i++] = c[j++];
            while ( j < n && c[j] == ' ') j++;
            if ( j < n ) c[i++] = ' ';
        }

        return new String(c).substring(0, i);
    }

    void reverse(char[] c, int i, int j) {
        char t;
        j--;
        while ( i < j ) {
            t = c[i]; c[i] = c[j]; c[j] = t;
            i++; j--;
        }
    }

    public String reverseWordsStringBuilder(String s) {
        if ( s == null || s.length() < 1 ) return "";
        List<String> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for ( int i = 0; i < s.length(); i++ ) {
            if ( s.charAt(i) == ' ') {
                if ( sb.length() != 0 ) {
                    list.add(sb.toString());
                    sb.setLength(0);
                }
            } else {
                sb.append(s.charAt(i));
            }
        }
        if ( sb.length() != 0 ) list.add(sb.toString());
        sb.setLength(0);
        for ( int i = list.size() - 1; i >= 0; i-- ) {
            if ( sb.length() != 0 ) sb.append(' ');
            sb.append(list.get(i));
        }
        return sb.toString();
    }
}

public class Main {
    public static void main(String[] args) {
        check("a");
        check("a bcd efgh i");
        check("  ab bcd    efgh i  ");
        check("  hello world!  ");
    }
    
    static void check(String input) {
        Solution s = new Solution();
        String ret = s.reverseWords(input);
        System.out.printf("%s\n", ret);
    }
}


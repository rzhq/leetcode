// start  2019-12-12 11:59:18
// finish 2019-12-12 12:13:03

import java.util.*;

class Solution {
    public int lengthOfLastWord(String s) {
        int j = s.length() - 1;
        while ( j > -1 && s.charAt(j) == ' ' ) j--; 
        int i = j;
        while ( i > -1 && s.charAt(i) != ' ' ) i--;
        return j - i;
    }
}

public class Main {
    public static void main(String[] args) {
        String input;
        check("");
        check(" ");
        check("a ");
        check("a");
        check(" a");
        check("aa");
        check(" aaa");
        check("aa aaaa");
    }
    
    static void check(String input) {
        Solution s = new Solution();
        int ret = s.lengthOfLastWord(input);
        System.out.printf("%d\n", ret);
    }
}


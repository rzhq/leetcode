// start  19-12-10 19:35
// finish 19-12-10 21:18
import java.util.*;

class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> list = new ArrayList<>(numRows);
        if ( numRows < 1 ) { return list; }
        for ( int i = 0; i < numRows; i++ ) {
            List<Integer> nextList = new ArrayList<>(i+1);
            nextList.add(1);
            for ( int j = 1; j < i; j++ ) {
                nextList.add(list.get(i-1).get(j-1) + list.get(i-1).get(j));
            }
            if ( i > 0 ) { nextList.add(1); }
            list.add(nextList);
        }
        return list;
    }
}

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        List<List<Integer>> l;
        l = s.generate(0);
        System.out.println(l);
        l = s.generate(1);
        System.out.println(l);
        l = s.generate(10);
        System.out.println(l);
    }
}


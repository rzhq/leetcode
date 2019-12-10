// start  19-12-10 21:20
// start  19-12-10 21:35
import java.util.*;

class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> row = new ArrayList<>(rowIndex);
        if ( rowIndex < 0 ) { return row; }
        for ( int i = 0; i <= rowIndex; i++ ) {
            row.add(0, 1);
            for ( int j = 1; j < i; j++ ) {
                row.set(j, row.get(j) + row.get(j+1));
            }
        }
        return row;
    }
}

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        List<Integer> l;
        l = s.getRow(0);
        System.out.println(l);
        l = s.getRow(1);
        System.out.println(l);
        l = s.getRow(2);
        System.out.println(l);
        l = s.getRow(3);
        System.out.println(l);
        l = s.getRow(4);
        System.out.println(l);
        l = s.getRow(5);
        System.out.println(l);
    }
}


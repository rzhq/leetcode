import java.util.*;

class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        if (intervals.length == 0) return new int[][] { newInterval };

        List<int[]> res = new LinkedList<>();
        int i = 0;

        while (i < intervals.length && intervals[i][1] < newInterval[0]) {
            res.add(intervals[i]);
            i += 1;
        }

        int[] temp = Arrays.copyOf(newInterval, 2);
        while (i < intervals.length && intervals[i][0] <= temp[1]) {
            temp[0] = Math.min(intervals[i][0], temp[0]);
            temp[1] = Math.max(intervals[i][1], temp[1]);
            i += 1;
        }
        res.add(temp);

        while (i < intervals.length) {
            res.add(intervals[i]);
            i += 1;
        }

        return res.toArray(new int[res.size()][]);
    }
}

public class Main {
    public static void main(String[] args) {
        int[][] input;
        int[] input2;
        input = new int[][] {};
        input2 = new int[] { 2, 5 };
        check(input, input2);
        input = new int[][] {{ 1, 3 }, { 6, 9 }};
        input2 = new int[] { 2, 5 };
        check(input, input2);
    }
    
    static void check(int[][] input, int[] input2) {
        Solution s = new Solution();
        int[][] ret = s.insert(input, input2);
        System.out.printf("%s\n", Arrays.deepToString(ret));
    }
}


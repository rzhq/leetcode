import java.util.*;

class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        HashSet<List<Integer>> hset = new HashSet<>();
        if (nums.length < 4) return new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        HashMap<Integer, HashSet<List<Integer>>> map = new HashMap<>();
        int req = 0;
        for (int i = 0; i < nums.length-1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                req = target - nums[i] - nums[j];
                HashSet<List<Integer>> set = map.get(req) == null ?
                    new HashSet<>() : map.get(req);
                set.add(Arrays.asList(i, j));
                map.put(req, set);
            }
        }
        int sum = 0;
        for (int i = 0; i < nums.length-1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                sum = nums[i] + nums[j];
                if (map.get(sum) != null) {
                    HashSet<List<Integer>> set = map.get(sum);
                    for (List<Integer> list : set) {
                        if (j < list.get(0)) {
                            hset.add(Arrays.asList(nums[i], nums[j], nums[list.get(0)], nums[list.get(1)]));
                        }
                    }
                }
            }
        }
    
        return new ArrayList<List<Integer>> (hset);
    }

    public List<List<Integer>> fourSumON3(int[] nums, int target) {
        HashSet<List<Integer>> set = new HashSet<> ();
        Arrays.sort(nums);
        int sum = 0;
        for (int i = 0; i < nums.length-3; i++) {
            for (int j = i + 1; j < nums.length-2; j++) {
                int k = j + 1, l = nums.length - 1;
                while (k < l) {
                    sum = nums[i] + nums[j] + nums[k] + nums[l];
                    if (sum > target) {
                        l--;
                    } else if (sum < target) {
                        k++;
                    } else {
                        set.add(Arrays.asList(nums[i], nums[j], nums[k], nums[l]));
                        k++;
                        l--;
                    }
                }
            }
        }
        
        return new ArrayList<List<Integer>> (set);
    }
}

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        List<List<Integer>> r = s.fourSum(new int[] {-3,-2,-1,0,0,1,2,3}, 0);
        System.out.println(r);
    }
}


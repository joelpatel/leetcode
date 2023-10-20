import java.util.HashMap;
import java.util.Map;

class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        var ans = solution.twoSum(new int[]{3, 3}, 6);
        System.out.println(ans[0] + " - " + ans[1]);
    }
}

class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        
        for (int i = 0; i < nums.length; i++) {
            int diff = target - nums[i];
            
            if (map.containsKey(diff)) {
                return new int[] {map.get(diff), i};
            }
            
            map.put(nums[i], i);
        }

        return new int[]{};
    }
}
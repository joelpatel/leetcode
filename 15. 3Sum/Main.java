import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        List<List<Integer>> result = solution.threeSum(new int[]{-1, 0, 1, 2, -1, -4});
        System.out.println(result);
    }
}

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        // sort nums
        Arrays.sort(nums);

        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i - 1] == nums[i]) {
                continue;
            } 

            int left = i + 1, right = nums.length - 1;

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum > 0) {
                    right--;
                } else if (sum < 0) {
                    left++;
                } else {
                    result.add(List.of(nums[i], nums[left], nums[right]));
                    left++;
                    right--;
                    
                    // move left and right till different element is detected
                    while (left <= nums.length - 1 && nums[left] == nums[left - 1]) {
                        left++;
                    }
                    while (right >= i + 1 && nums[right] == nums[right + 1]) {
                        right --;
                    }
                }
            }
        }
        
        return result;
    }
}
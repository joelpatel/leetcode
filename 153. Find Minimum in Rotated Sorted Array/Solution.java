public class Solution {
    public int findMin(int[] nums) {
        if (nums.length == 1 || nums[0] < nums[nums.length - 1]) {
            return nums[0];
        }

        int left = 0, right = nums.length - 1;
        int mid;

        while (left < right) {
            if (nums[left] < nums[right]) {
                return nums[left];
            }

            mid = (left + right) / 2;
            if (nums[left] < nums[mid]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return nums[left];
    }
}
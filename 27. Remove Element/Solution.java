public class Solution {
    public int removeElement(int[] nums, int val) {
        int lastNonValIndex = -1;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] == val) {
                if (lastNonValIndex != -1) {
                    // swap
                    nums[i] = nums[lastNonValIndex];
                    nums[lastNonValIndex] = val;
                    lastNonValIndex--;
                }
            } else if (lastNonValIndex == -1) {
                lastNonValIndex = i;
            }
        }

        return lastNonValIndex + 1;
    }
}
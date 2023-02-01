class Main {
    public static void main(String[] args) {
        System.out.println("287. Find the Duplicate Number");

        int[] numbers = { 1, 3, 4, 2, 2 };

        Solution solution = new Solution();
        System.out.println(">> result: " + solution.findDuplicate(numbers));
    }
}

// Fast and slow pointer approach
// Time Complexity: O(n)
// Space Complexity: O(1)

class Solution {

    public int findDuplicate(int[] nums) {
        int fast = nums[nums[0]];
        int slow = nums[0];
        int slow2 = nums[0];

        while (fast != slow) {
            slow = nums[slow];
            fast = nums[nums[fast]];
        }
        slow = nums[slow];
        while (slow2 != slow) {
            slow2 = nums[slow2];
            slow = nums[slow];
        }
        return slow;
    }
}
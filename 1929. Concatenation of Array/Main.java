class Main {
    public static void main(String[] args) {
        int[] nums = { 1, 2, 3 };
        Solution solution = new Solution();
        int[] result = solution.getConcatenation(nums);
        System.out.println(">> result:");
        for (int i = 0; i < result.length; i++) {
            System.out.println(">> " + result[i]);
        }
    }
}

class Solution {
    public int[] getConcatenation(int[] nums) {
        int n = nums.length;
        int[] ans = new int[2 * n];
        for (int i = 0; i < n; i++) {
            ans[i] = nums[i];
            ans[i + n] = nums[i];
        }
        return ans;
    }
}
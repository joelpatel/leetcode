class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] result = solution.productExceptSelf(new int[]{-1, 1, 0, -3, 3});
        for (int el : result) {
            System.out.println(el);
        }
    }
}

class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];
        int multiplier = 1;
        
        result[0] = multiplier;
        for (int i = 1; i < nums.length; i++) {
            multiplier *= nums[i - 1];
            result[i] = multiplier;
        }

        multiplier = 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            multiplier *= nums[i + 1];
            result[i] *= multiplier;
        }

        return result;
    }
}
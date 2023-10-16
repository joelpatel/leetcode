import java.util.HashSet;
import java.util.Set;

class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.containsDuplicate(new int[]{1,2,3,4}));
        System.out.println(solution.containsDuplicate(new int[]{1,1,2,3,4}));
    }
}

class Solution {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> elementSet = new HashSet<>();
        
        for (int i = 0; i < nums.length; i++) {
            if (elementSet.contains(nums[i])) {
                return true;
            } else {
                elementSet.add(nums[i]);
            }
        }

        return false;
    }
}
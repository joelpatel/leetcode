import java.util.HashSet;
import java.util.Set;

class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.longestConsecutive(new int[]{100, 4, 200, 1, 3, 2}));
    }
}

class Solution {
    public int longestConsecutive(int[] nums) {
        int longest = 0;

        Set<Integer> set = new HashSet<>(nums.length);

        for (int num : nums) {
            set.add(num);
        }

        for (int num : set) {
            if (!set.contains(num - 1)) {
                int count = 0;
                while (set.contains(num)) {
                    count++;
                    num++;
                }
                longest = Math.max(count, longest);
            }
            if (longest > nums.length / 2) break;
        }

        return longest;
    }
}
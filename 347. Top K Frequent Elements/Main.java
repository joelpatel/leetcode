import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.Map.Entry;

class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] result = solution.topKFrequent(new int[]{1,2}, 2);
        for (int el : result) {
            System.out.println(el);
        }
    }
}

class Solution {
    /**
     * Measure count of each element.
     * Fill a bucket of list based on the count of each element.
     * Go over the bucket in descending order till you have k elements poped.
     */
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int el : nums) {
            countMap.put(el, countMap.getOrDefault(el, 0) + 1);
        }

        Stack<Integer>[] buckets = new Stack[nums.length + 1];
        for (Entry<Integer, Integer> entry : countMap.entrySet()) {
            Stack<Integer> bucket = buckets[entry.getValue()];
            if (bucket == null) {
                bucket = new Stack<>();
                buckets[entry.getValue()] = bucket;
            }
            bucket.push(entry.getKey());
        }

        int[] result = new int[k];
        int j = 0;
        for (int i = nums.length; i >= 0; i--) {
            Stack<Integer> bucket = buckets[i];
            while (bucket != null && !bucket.isEmpty()){
                result[j] = bucket.pop();
                j++;
                if (j == k) return result;
            }
        }

        return result;
    }
}
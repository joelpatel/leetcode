class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.maxProfit(new int[]{7,1,5,3,6,4}));
    }
}

class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length == 1) {
            return 0;
        }

        int maxProfit = 0, i = 0, j = i + 1;
        
        while (i <= prices.length - 2 && j <= prices.length - 1) {
            if (prices[i] > prices[j]) {
                i = j;
            } else {
                maxProfit = Math.max(maxProfit, prices[j] - prices[i]);
            }
            j++;
        }
        
        
        return maxProfit;
    }
}
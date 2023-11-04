class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        
        System.out.println(solution.maxArea(new int[]{1, 2, 4, 3}));
    }
}

class Solution {
    private int calculateArea(int x1, int x2, int y1, int y2) {
        return (x2 - x1) * Math.min(y1, y2);
    }

    public int maxArea(int[] height) {
        int maxArea = 0, left = 0, right = height.length - 1;
        
        while (left < right) {
            maxArea = Math.max(maxArea, calculateArea(left, right, height[left], height[right]));
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        
        return maxArea;
    }
}
import java.util.ArrayList;
import java.util.List;

class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        List<List<Integer>> result = solution.generate(5);
        System.out.println(">> result = " + result);
    }
}

class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        
        for (int i = 0; i < numRows; i++) {
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    row.add(1);
                } else {
                    // [i-1, j-1] + [i-1, j] 
                    row.add(result.get(i-1).get(j-1) + result.get(i-1).get(j));
                }
            }
            result.add(row);
        }
        return result;
    }
}
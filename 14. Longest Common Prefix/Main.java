class Main {
    public static void main(String[] args) {
        String[] strs = new String[] {"flower", "flow", "flight"};
        Solution solution = new Solution();
        String result = solution.longestCommonPrefix(strs);
        System.out.println(">> result = " + result);
    }
}

class Solution {
    public String longestCommonPrefix(String[] strs) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < strs[0].length(); i++) {
            for (String s : strs) {
                // check for the breaking case
                // i.e., either there's no match or there are no elements in 's'
                if (i == s.length() || strs[0].charAt(i) != s.charAt(i)) {
                    return builder.toString();
                }
            }
            // append current character to builder
            builder.append(strs[0].charAt(i));
        }

        return builder.toString();
    }
}
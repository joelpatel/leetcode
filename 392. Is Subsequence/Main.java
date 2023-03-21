class Main {
    public static void main(String[] args) {
        String subSequence = "ace";
        String sequence = "abcde";
        Solution solution = new Solution();
        Boolean result = solution.isSubsequence(subSequence, sequence);
        System.out.println(">> result: " + result);
    }
}

class Solution {
    public boolean isSubsequence(String s, String t) {
        char[] sc = s.toCharArray();
        char[] st = t.toCharArray();
        int i = 0;
        int j = 0;
        while (i < sc.length && j < st.length) {
            if (sc[i] == st[j]) {
                i++;
            }
            j++;
        }
        return i == sc.length;
    }
}
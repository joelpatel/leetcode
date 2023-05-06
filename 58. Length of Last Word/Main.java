class Main {
    public static void main(String[] args) {
        String s = "hello world ";

        Solution solution = new Solution();
        int result = solution.lengthOfLastWord(s);
        System.out.println(">> result = " + result);
        
    }
}

class Solution {
    public int lengthOfLastWord(String s) {
        char[] charS = s.toCharArray();
        int length = 0;

        for (int i = charS.length - 1; i >= 0; i--) {
            if (length == 0 && charS[i] == ' ') continue;
            
            if (charS[i] == ' ') break;

            length++;
        }

        return length;
    }
}
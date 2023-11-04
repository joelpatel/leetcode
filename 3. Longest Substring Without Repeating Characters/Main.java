import java.util.HashSet;
import java.util.Set;

class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.lengthOfLongestSubstring("abcabcbb"));
    }
}

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int maxLength = 0;
        
        char[] charArray = s.toCharArray();
        Set<Character> charSet = new HashSet<>();
        
        int i = 0;

        for (int j = 0; j < charArray.length; j++) {
            while (charSet.contains(charArray[j])) {
                charSet.remove(charArray[i]);
                i++;
            }
            charSet.add(charArray[j]);
            maxLength = Math.max(maxLength, j - i + 1);
        }

        return maxLength;
    }
}
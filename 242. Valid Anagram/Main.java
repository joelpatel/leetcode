import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isAnagram(null, null));
        System.out.println(solution.isAnagram("a", "b"));
        System.out.println(solution.isAnagram("ab", "ba"));

        ASCIISolution asciiSolution = new ASCIISolution();
        System.out.println(asciiSolution.isAnagram(null, null));
        System.out.println(asciiSolution.isAnagram("null ", " null"));
        System.out.println(asciiSolution.isAnagram("null ", " Null"));
    }
}

class Solution {
    public boolean isAnagram(String s, String t) {
        if (s == null || t == null) {
            return false;
        }
        
        char[] charArray = new char[26];
        
        for (int i = 0; i < s.length(); i++) {
            charArray[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < t.length(); i++) {
            charArray[t.charAt(i) - 'a']--;
        }
        
        for (int i = 0; i < 26; i++) {
            if (charArray[i] != 0) {
                return false;
            }
        }
        
        return true;
    }
}

class ASCIISolution {
    public boolean isAnagram(String s, String t) {
        if (s == null || t == null) {
            return false;
        }

        Map<Character, Integer> charCountMap = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            Integer count = charCountMap.get(s.charAt(i));
            if (count == null) {
                charCountMap.put(s.charAt(i), 1);
            } else {
                charCountMap.put(s.charAt(i), ++count);
            }
        }

        for (int i = 0; i < t.length(); i++) {
            Integer count = charCountMap.get(t.charAt(i));
            if (count == null) {
                return false; // character not present in s
            } else {
                charCountMap.put(t.charAt(i), --count);
            }
        }

        for (Entry<Character, Integer> entry : charCountMap.entrySet()) {
            if (entry.getValue() != 0) {
                return false;
            }
        }


        return true;
    }
}
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public String minWindow(String s, String t) {
        if (s.length() < t.length()) {
            return "";
        }

        int ansL = 0, ansR = -1, l = 0, need = 0, have = 0, minLen = s.length();
        
        Map<Character, Integer> needMap = new HashMap<>();
        for (int r = 0; r < t.length(); r++) {
            needMap.put(t.charAt(r), needMap.getOrDefault(t.charAt(r), 0) + 1);
            need = needMap.size();
        }

        Map<Character, Integer> haveMap = new HashMap<>();
        for (int r = 0; r < s.length(); r++) {
            if (have < need) {
                // if char is in need map
                    // increment char in have map
                    // check if have map's value and need map's value for char is equal
                        // if yes --> increment have
                if (needMap.containsKey(s.charAt(r))) {
                    int count = haveMap.getOrDefault(s.charAt(r), 0);
                    haveMap.put(s.charAt(r), count + 1);
                    if (count + 1 == needMap.get(s.charAt(r))) {
                        have++;
                    }
                }
            }
            // move left pointer
            while (have == need) {
                if (r - l + 1 <= minLen) {
                    ansR = r;
                    ansL = l;
                    minLen = r - l + 1;
                }

                Integer count = haveMap.get(s.charAt(l));
                if (count != null) {
                    haveMap.put(s.charAt(l), count - 1);
                    if (count - 1 < needMap.get(s.charAt(l))) {
                        have--;
                    }
                }
                l++;
            }
        }

        return s.substring(ansL, ansR + 1);
    }
}

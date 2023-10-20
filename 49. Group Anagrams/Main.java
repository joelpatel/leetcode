import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.groupAnagrams(new String[]{"ddddddddddg","dgggggggggg"}));
    }
}

class Solution {
    public List<List<String>> groupAnagramsLowercase(String[] strs) {
        Map<String, List<String>> bitmapStringsMap = new HashMap<>();

        for (String s : strs) {
            int[] bitmap = new int[26];
            
            for (int i = 0; i < s.length(); i++) {
                bitmap[s.charAt(i) - 'a']++;
            }

            StringBuilder builder = new StringBuilder();
            for (int bit : bitmap) {
                builder.append(bit).append(",");
            }

            String key = builder.toString();
            List<String> stringList;
            if ((stringList = bitmapStringsMap.get(key)) != null) {
                stringList.add(s);
            } else {
                stringList = new ArrayList<>();
                stringList.add(s);
                bitmapStringsMap.put(key, stringList);
            }
        }
        
        return new ArrayList<>(bitmapStringsMap.values());
    }

    // for ASCII
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<Map<Character, Integer>, List<String>> grouped = new HashMap<>();
        
        for (String s : strs) {
            Map<Character, Integer> charCountMap = new HashMap<>();

            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (!charCountMap.containsKey(c)) {
                    charCountMap.put(c, 1);
                } else {
                    charCountMap.put(c, charCountMap.get(c) + 1);
                }
            }

            if (!grouped.containsKey(charCountMap)) {
                grouped.put(charCountMap, new ArrayList<>());
            }

            grouped.get(charCountMap).add(s);
        }

        return new ArrayList<>(grouped.values());
    }
}
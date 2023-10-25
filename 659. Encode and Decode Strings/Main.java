import java.util.ArrayList;
import java.util.List;

class Main {
    public static void main(String[] args) {
        List<String> input = List.of("32#howdy", "wor%45#world");
        Solution solution = new Solution();
    
        String encoded = solution.encode(input);
        List<String> output = solution.decode(encoded);
        
        boolean status = true;
        if (input.size() == output.size()) {
            for (int i = 0; i < input.size(); i++) {
                status = status && (input.get(i).equals(output.get(i)));
            }
        } else {
            status = false;
        }
        System.out.println(status);
        System.out.println(">>>> input = " + input);
        System.out.println(">>>> output = " + output);
    }
}

class Solution {
    public String encode(List<String> strs) {
        StringBuilder builder = new StringBuilder();
        for (String str : strs) {
            builder.append(str.length()).append("#").append(str);
        }
        return builder.toString();
    }

    public List<String> decode(String str) {
        List<String> result = new ArrayList<>();
        int i = 0;

        while (i < str.length()) {
            int j = i;
            while (str.charAt(j) != '#') {
                j++;
            }

            int length = Integer.parseInt(str.substring(i, j));
            i = j + 1 + length;
            result.add(str.substring(j + 1, i));
        }

        return result;
    }
}
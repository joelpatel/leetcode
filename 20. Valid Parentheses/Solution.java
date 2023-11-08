import java.util.Map;
import java.util.Stack;

public class Solution {
    public boolean isValid(String s) {
        Map<Character, Character> reversePairs = Map.of( ')', '(', '}', '{', ']', '[');

        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else if (c == ')' || c == '}' || c == ']') {
                if (stack.isEmpty()) {
                    return false;
                } else if (stack.peek() == reversePairs.get(c)) {
                    stack.pop();
                } else {
                    return false;
                }
            } else {
                return false;    
            }
        }
        
        return stack.isEmpty();
    }
}
class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isPalindrome(" a#bA"));
        System.out.println(solution.isPalindrome("0P"));
        System.out.println(solution.isPalindrome(" "));
        System.out.println(solution.isPalindrome(""));
    }
}

class Solution {
    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        int left = 0, right = s.length() - 1;

        // discard non-alphanumeric characters
        while (left < s.length() && !isAlphnumeric(s.charAt(left))) left++;
        while (right >= 0 && !isAlphnumeric(s.charAt(right))) right--;

        while (left <= right) {
            // check equality
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }

            // move pointers
            left++;
            right--;

            // discard non-alphanumeric characters
            while (left < s.length() && !isAlphnumeric(s.charAt(left))) left++;
            while (right >= 0 && !isAlphnumeric(s.charAt(right))) right--;
        }

        return true;
    }

    private boolean isAlphnumeric(char c) {
        if ((c >= '0' && c <= '9') || (c >= 'a' && c <= 'z')) {
            return true;
        } else {
            return false;
        }
    }
}
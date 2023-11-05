class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.characterReplacement("ABC", 2)); // 5
    }
}

class Solution {
    public int characterReplacement(String s, int k) {
        int longest = 0;
        int maxFreq = 0;

        int[] charBitmap = new int[26];
        int l = 0;
        for (int r = 0; r < s.length(); r++) {
            // add character to the bitmap
            // calculate the condition (can a replacement occur in the current window)
            // condition ==> windowSize - maxFreq <= k
            // if yes
            //      calculate longest
            // if no
            //      remove char from the bitmap
            //      no need to decrement the maxFreq (because in order for longest to increase, maxFreq will have to increase)
            //      increment left pointer
            int charIndex = s.charAt(r) - 'A';
            charBitmap[charIndex]++;
            maxFreq = Math.max(maxFreq, charBitmap[charIndex]);
            if ((r - l + 1) - maxFreq > k) {
                charBitmap[s.charAt(l) - 'A']--;
                l++;
            }
            longest = Math.max(maxFreq, r - l + 1);
        }

        return longest;
    }
}
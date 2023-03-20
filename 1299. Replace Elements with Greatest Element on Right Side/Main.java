class Main {
    public static void main(String[] args) {
        int[] arr = { 17, 18, 5, 4, 6, 1 };
        // int[] arr = { 400 };
        Solution solution = new Solution();
        int[] result = solution.replaceElements(arr);
        System.out.println(">> result:");
        for (int i = 0; i < result.length; i++) {
            System.out.println(">> " + result[i]);
        }
    }
}

class Solution {
    public int[] replaceElements(int[] arr) {
        // use last element as temp
        int lastIndex = arr.length - 1;
        int max = arr[lastIndex];
        for (int i = arr.length - 2; i >= 0; i--) {
            arr[lastIndex] = max;
            if (arr[i] > max)
                max = arr[i];
            arr[i] = arr[lastIndex];
        }
        arr[arr.length - 1] = -1;
        return arr;
    }
}
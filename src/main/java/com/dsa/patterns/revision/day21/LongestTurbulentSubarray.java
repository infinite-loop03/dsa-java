package com.dsa.patterns.revision.day21;

public class LongestTurbulentSubarray {

    static void main() {
        LongestTurbulentSubarray longestTurbulentSubarray = new LongestTurbulentSubarray();
        int[] arr = {9, 4, 2, 10, 7, 8, 8, 1, 9};
        System.out.println(longestTurbulentSubarray.maxTurbulenceSize(arr));
    }

    public int maxTurbulenceSize(int[] arr) {
        String previousSign = "";
        int left = 0;
        int right = 1;
        int result = 1;

        while (right < arr.length) {
            if (arr[right - 1] < arr[right] && !previousSign.equals("<")) {
                result = Math.max(result, right - left + 1);
                right++;
                previousSign = "<";
            } else if (arr[right - 1] > arr[right] && !previousSign.equals(">")) {
                result = Math.max(result, right - left + 1);
                right++;
                previousSign = ">";
            } else {
                right = arr[right - 1] == arr[right] ? right + 1 : right;
                left = right - 1;
                previousSign = "";
            }
        }
        return result;
    }
}

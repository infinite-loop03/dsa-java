package com.dsa.patterns.revision.slidingwindow;

public class LongestTurbulentSubarray {

    public static void main(String[] args) {
        LongestTurbulentSubarray longestTurbulentSubarray = new LongestTurbulentSubarray();
        int[] arr = {9, 4, 2, 10, 7, 8, 8, 1, 9};
        System.out.println(longestTurbulentSubarray.maxTurbulenceSize(arr));
    }

    public int maxTurbulenceSize(int[] arr) {
        int left = 0;
        int right = 1;
        int result = 1;
        String previousSign = "";

        while (right < arr.length) {
            if (arr[right - 1] > arr[right] && !previousSign.equals(">")) {
                result = Math.max(result, right - left + 1);
                right++;
                previousSign = ">";
            } else if (arr[right - 1] < arr[right] && !previousSign.equals("<")) {
                result = Math.max(result, right - left + 1);
                right++;
                previousSign = "<";
            } else {
                right = arr[right] == arr[right - 1] ? right + 1 : right;
                left = right - 1;
                previousSign = "";
            }
        }
        return result;
    }
}

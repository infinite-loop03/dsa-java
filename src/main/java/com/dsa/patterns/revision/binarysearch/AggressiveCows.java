package com.dsa.patterns.revision.binarysearch;

import java.util.Arrays;

public class AggressiveCows {

    static void main() {
        AggressiveCows aggressiveCows = new AggressiveCows();
        int[] stalls = {6, 4, 3, 16, 20, 7, 18, 10};
        int k = 5;
        System.out.println(aggressiveCows.aggressiveCows(stalls, k));
    }

    public int aggressiveCows(int[] arr, int k) {
        Arrays.sort(arr);
        int low = 1;
        int high = arr[arr.length - 1] - arr[0];
        System.out.println(Arrays.toString(arr));
        while (low < high) {
            int mid = low + (high - low + 1) / 2;
            if (canPlace(mid, arr, k)) {
                low = mid;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }

    private boolean canPlace(int distance, int[] arr, int k) {
        int cows = 1;
        int last = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] - last >= distance) {
                cows++;
                last = arr[i];
                if (cows >= k) return true;
            }
        }
        return cows >= k;
    }
}

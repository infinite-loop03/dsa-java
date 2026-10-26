package com.dsa.patterns.revision.day21;

public class SplitArrayLargestSum {

    static void main() {
        SplitArrayLargestSum splitArrayLargestSum = new SplitArrayLargestSum();
        int[] nums = {7, 2, 5, 10, 8};
        int k = 2;
        System.out.println(splitArrayLargestSum.splitArray(nums, k));
    }

    public int splitArray(int[] nums, int k) {
        int low = 0;
        int high = 0;

        for (int num : nums) {
            low = Math.max(low, num);
            high += num;
        }

        while (low < high) {
            int mid = low + (high - low) / 2;
            if (canSplit(mid, nums, k)) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    private boolean canSplit(int sum, int[] nums, int k) {
        int splits = 1;
        int currentSum = 0;

        for (int num : nums) {
            currentSum += num;
            if (currentSum > sum) {
                splits++;
                currentSum = num;
            }
        }
        return splits <= k;
    }
}

package com.dsa.patterns.revision.binarysearch;

public class SplitArrayLargestSum {

    public static void main(String[] args) {
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

            if (canAchieve(mid, nums, k)) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;

    }

    private boolean canAchieve(int mid, int[] nums, int k) {
        int sum = 0;
        int minPartitions = 1;

        for (int num : nums) {
            sum += num;
            if (sum > mid) {
                minPartitions++;
                sum = num;
            }
        }
        return minPartitions <= k;
    }
}

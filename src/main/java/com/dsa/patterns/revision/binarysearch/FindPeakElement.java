package com.dsa.patterns.revision.binarysearch;

public class FindPeakElement {

    public static void main(String[] args) {
        FindPeakElement findPeakElement = new FindPeakElement();
        int[] nums = {1};
        System.out.println(findPeakElement.findPeakElement(nums));
    }

    public int findPeakElement(int[] nums) {
        int low = 0;
        int high = nums.length - 1;

        while (low < high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] < nums[mid + 1]) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }
}

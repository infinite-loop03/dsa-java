package com.dsa.patterns.revision.day7;

public class FindPeakElement {

    static void main() {
        FindPeakElement findPeakElement = new FindPeakElement();
        int[] nums = {1, 2, 3, 1};
        System.out.println(findPeakElement.findPeakElement(nums));
    }

    public int findPeakElement(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < nums[mid + 1]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
}

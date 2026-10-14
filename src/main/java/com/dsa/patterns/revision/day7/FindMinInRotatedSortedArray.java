package com.dsa.patterns.revision.day7;

public class FindMinInRotatedSortedArray {

    static void main() {
        FindMinInRotatedSortedArray findMinInRotatedSortedArray = new FindMinInRotatedSortedArray();
        int[] nums = {3, 4, 5, 1, 2};
        System.out.println(findMinInRotatedSortedArray.findMin(nums));
    }

    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return nums[left];
    }
}

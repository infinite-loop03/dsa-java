package com.dsa.patterns.revision.slidingwindow;

public class CountNumberOfNiceSubarrays {

    public static void main(String[] args) {
        CountNumberOfNiceSubarrays countNumberOfNiceSubarrays = new CountNumberOfNiceSubarrays();
        int[] nums = {1, 1, 2, 1, 1};
        int k = 3;
        System.out.println(countNumberOfNiceSubarrays.numberOfSubarrays(nums, k));
    }

    public int numberOfSubarrays(int[] nums, int k) {
        int left = 0;
        int mid = 0;
        int result = 0;
        int oddCount = 0;

        for (int num : nums) {
            if (num % 2 == 1) {
                oddCount++;
            }

            while (oddCount > k) {
                if (nums[left] % 2 == 1) oddCount--;
                left++;
                mid = left;
            }

            if (oddCount == k) {
                while (nums[mid] % 2 != 1) {
                    mid++;
                }
                result += mid - left + 1;
            }
        }
        return result;
    }

}

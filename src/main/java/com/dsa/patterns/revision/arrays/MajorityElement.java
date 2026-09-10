package com.dsa.patterns.revision.arrays;

public class MajorityElement {

    public static void main(String[] args) {
        MajorityElement majorityElement = new MajorityElement();
        int[] nums = {3, 2, 3};
        System.out.println(majorityElement.majorityElement(nums));
    }

    public int majorityElement(int[] nums) {
        int count = 0;
        int candidate = 0;

        for (int num : nums) {
            if (count == 0) {
                candidate = num;
                count = 1;
            } else {
                if (candidate == num) count++;
                else count--;
            }
        }

        return candidate;
    }
}

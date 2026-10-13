package com.dsa.patterns.revision.day21;

public class MajorityElement {

    static void main() {
        MajorityElement majorityElement = new MajorityElement();
        int[] nums = {2, 2, 1, 1, 1, 2, 2};
        System.out.println(majorityElement.majorityElement(nums));
    }

    public int majorityElement(int[] nums) {
        int count = 0;
        int majorityNum = 0;

        for (int num : nums) {
            if (count == 0) {
                count++;
                majorityNum = num;
            } else {
                if (num == majorityNum) {
                    count++;
                } else {
                    count--;
                }
            }
        }
        return majorityNum;
    }
}

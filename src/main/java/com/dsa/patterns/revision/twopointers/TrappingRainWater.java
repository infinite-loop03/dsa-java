package com.dsa.patterns.revision.twopointers;

public class TrappingRainWater {

    public static void main(String[] args) {
        TrappingRainWater trappingRainWater = new TrappingRainWater();
        int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println(trappingRainWater.trap(height));
    }

    public int trap(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int totalWater = 0;
        int leftMax = height[left];
        int rightMax = height[right];

        while (left < right) {
            if (leftMax < rightMax) {
                left++;
                leftMax = Math.max(leftMax, height[left]);
                totalWater += leftMax - height[left];
            } else {
                right--;
                rightMax = Math.max(rightMax, height[right]);
                totalWater += rightMax - height[right];
            }
        }
        return totalWater;
    }
}

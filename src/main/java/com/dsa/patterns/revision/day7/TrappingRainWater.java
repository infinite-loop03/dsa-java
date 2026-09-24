package com.dsa.patterns.revision.day7;

public class TrappingRainWater {

    public static void main(String[] args) {
        TrappingRainWater trappingRainWater = new TrappingRainWater();
        int[] height = {4,2,0,3,2,5};
        System.out.println(trappingRainWater.trap(height));
    }

    public int trap(int[] height) {
        int left = 0;
        int right = height.length - 1;

        int leftMax = height[left];
        int rightMax = height[right];

        int totalWater = 0;

        while (left <= right) {
            if (leftMax < rightMax) {
                if (height[left] < leftMax) {
                    totalWater += leftMax - height[left];
                } else {
                    leftMax = height[left];
                }
                left++;
            } else {
                if (height[right] < rightMax) {
                    totalWater += rightMax - height[right];
                } else {
                    rightMax = height[right];
                }
                right--;
            }
        }
        return totalWater;
    }
}

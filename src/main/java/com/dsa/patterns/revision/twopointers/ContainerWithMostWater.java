package com.dsa.patterns.revision.twopointers;

public class ContainerWithMostWater {

    public static void main(String[] args) {
        ContainerWithMostWater containerWithMostWater = new ContainerWithMostWater();
        int[] nums = {1, 1, 1};
        System.out.println(containerWithMostWater.maxArea(nums));
    }

    public int maxArea(int[] height) {
        int maxArea = 0;
        int left = 0;
        int right = height.length - 1;

        while (left < right) {
            int area = Math.min(height[left], height[right]) * (right - left);
            maxArea = Math.max(area, maxArea);
            if (height[left] < height[right]) left++;
            else right--;
        }
        return maxArea;
    }

}

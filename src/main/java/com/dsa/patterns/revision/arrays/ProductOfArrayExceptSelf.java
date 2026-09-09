package com.dsa.patterns.revision.arrays;

import java.util.Arrays;

public class ProductOfArrayExceptSelf {

    public static void main(String[] args) {
        ProductOfArrayExceptSelf productOfArrayExceptSelf = new ProductOfArrayExceptSelf();
        int[] nums = {-1, 1, 0, -3, 3};
        System.out.println(Arrays.toString(productOfArrayExceptSelf.productExceptSelf(nums)));
    }

    public int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];

        int leftProduct = 1;
        int rightProduct = 1;

        for (int i = 0; i < nums.length; i++) {
            result[i] = leftProduct;
            leftProduct = leftProduct * nums[i];
        }

        for (int i = nums.length - 1; i > -1; i--) {
            result[i] = rightProduct * result[i];
            rightProduct = rightProduct * nums[i];
        }

        return result;
    }
}

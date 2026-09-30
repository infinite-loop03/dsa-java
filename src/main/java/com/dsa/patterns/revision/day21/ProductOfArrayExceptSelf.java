package com.dsa.patterns.revision.day21;

import java.util.Arrays;

public class ProductOfArrayExceptSelf {

    public static void main(String[] args) {
        ProductOfArrayExceptSelf productOfArrayExceptSelf = new ProductOfArrayExceptSelf();
        int[] nums = {1, 2, 3, 4};
        System.out.println(Arrays.toString(productOfArrayExceptSelf.productExceptSelf(nums)));
    }

    public int[] productExceptSelf(int[] nums) {
        int leftProduct = 1;
        int rightProduct = 1;

        int[] result = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            result[i] = leftProduct;
            leftProduct *= nums[i];
        }

        for (int i = nums.length - 1; i >= 0; i--) {
            result[i] = rightProduct * result[i];
            rightProduct *= nums[i];
        }
        return result;
    }
}

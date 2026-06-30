package com.dsa.patterns.greedy;

public class JumpGameII {

    public static void main(String[] args) {
        JumpGameII jumpGameII = new JumpGameII();
        int[] nums = {2, 3, 0, 1, 4};
        System.out.println(jumpGameII.jump(nums));
    }

    public int jump(int[] nums) {
        int maxReach = 0;
        int jumps = 0;
        int currEnd = 0;

        for (int i = 0; i < nums.length - 1; i++) {
            maxReach = Math.max(maxReach, i + nums[i]);

            if (i == currEnd) {
                jumps++;
                currEnd = maxReach;
            }
        }
        return jumps;
    }
}


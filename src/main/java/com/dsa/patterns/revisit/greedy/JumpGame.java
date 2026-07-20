package com.dsa.patterns.revisit.greedy;

public class JumpGame {

    public static void main(String[] args) {
        JumpGame jumpGame = new JumpGame();
        int[] nums = {3, 2, 1, 0, 4};
        System.out.println(jumpGame.canJump(nums));
    }

    private boolean canJump(int[] nums) {
        int maxReach = 0;

        for (int i = 0; i < nums.length; i++) {
            if (i > maxReach) return false;
            maxReach = Math.max(maxReach, i + nums[i]);
        }

        return true;
    }
}

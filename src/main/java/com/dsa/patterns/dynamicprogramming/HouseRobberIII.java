package com.dsa.patterns.dynamicprogramming;

import com.dsa.patterns.trees.TreeNode;

public class HouseRobberIII {

    public static void main(String[] args) {
        HouseRobberIII houseRobberIII = new HouseRobberIII();
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(1);
        root.left.left = new TreeNode(2);
        root.left.left.left = new TreeNode(3);
        System.out.println(houseRobberIII.rob(root));
    }

    public int rob(TreeNode root) {
        int[] result = solve(root);

        return Math.max(result[0], result[1]);
    }

    public int[] solve(TreeNode node) {
        if (node == null) return new int[]{0, 0};
        int[] left = solve(node.left);
        int[] right = solve(node.right);

        int notRob = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        int rob = left[0] + right[0] + node.val;

        return new int[]{notRob, rob};
    }
}

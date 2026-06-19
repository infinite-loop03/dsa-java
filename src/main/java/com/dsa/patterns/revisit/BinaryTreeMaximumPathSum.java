package com.dsa.patterns.revisit;

import com.dsa.patterns.trees.TreeNode;

public class BinaryTreeMaximumPathSum {

    public static void main(String[] args) {
        BinaryTreeMaximumPathSum binaryTreeMaximumPathSum = new BinaryTreeMaximumPathSum();
        TreeNode root = new TreeNode(-10);

        root.left = new TreeNode(9);
        root.right = new TreeNode(20);

        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        System.out.println(binaryTreeMaximumPathSum.maxPathSum(root));
    }

    public int maxPathSum(TreeNode root) {
        int[] maxSum = {Integer.MIN_VALUE};
        gainFromTree(root, maxSum);
        return maxSum[0];
    }

    private int gainFromTree(TreeNode node, int[] maxSum) {
        if (node == null) return 0;

        int gainFromLeft = Math.max(gainFromTree(node.left, maxSum), 0);
        int gainFromRight = Math.max(gainFromTree(node.right, maxSum), 0);

        int localSum = gainFromLeft + node.val + gainFromRight;
        maxSum[0] = Math.max(localSum, maxSum[0]);

        return Math.max(gainFromLeft, gainFromRight) + node.val;
    }

}

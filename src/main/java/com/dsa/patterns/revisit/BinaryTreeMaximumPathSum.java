package com.dsa.patterns.revisit;

import com.dsa.patterns.trees.TreeNode;

public class BinaryTreeMaximumPathSum {

    int maxSum = Integer.MIN_VALUE;

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
        gainFromTree(root);
        return maxSum;
    }

    private int gainFromTree(TreeNode node) {
        if (node == null) return 0;

        int gainFromLeft = Math.max(gainFromTree(node.left), 0);
        int gainFromRight = Math.max(gainFromTree(node.right), 0);

        int localSum = gainFromLeft + node.val + gainFromRight;
        System.out.println(localSum);
        maxSum = Math.max(localSum, maxSum);

        return Math.max(gainFromLeft, gainFromRight) + node.val;
    }

}

package com.dsa.patterns.dynamicprogramming;

import com.dsa.patterns.trees.TreeNode;

public class BinaryTreeCameras {

    public static void main(String[] args) {
        BinaryTreeCameras binaryTreeCameras = new BinaryTreeCameras();
        TreeNode root = new TreeNode(0);
        root.left = new TreeNode(0);
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(0);
        System.out.println(binaryTreeCameras.minCameraCover(root));
    }

    public int minCameraCover(TreeNode root) {
        int[] result = solve(root);
        return Math.min(result[0], result[1]);
    }

    private int[] solve(TreeNode node) {
        if (node == null) {
            return new int[]{Integer.MAX_VALUE / 2, 0, 0};
        }

        int[] left = solve(node.left);
        int[] right = solve(node.right);

        int installed = 1 + Math.min(left[0], Math.min(left[1], left[2])) + Math.min(right[0], Math.min(right[1], right[2]));

        int coveredButNotInstalled = Math.min(left[0] + Math.min(right[0], right[1]),
                right[0] + Math.min(left[0], left[1]));

        int notCovered = left[1] + right[1];

        return new int[]{installed, coveredButNotInstalled, notCovered};
    }
}

package com.dsa.patterns.trees;

import java.util.HashMap;
import java.util.Map;

public class PathSumIII {

    public static void main(String[] args) {
        PathSumIII pathSumIII = new PathSumIII();

        TreeNode root = new TreeNode(10);

        root.left = new TreeNode(5);
        root.right = new TreeNode(-3);

        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(2);
        root.right.right = new TreeNode(11);

        root.left.left.left = new TreeNode(3);
        root.left.left.right = new TreeNode(-2);
        root.left.right.right = new TreeNode(1);

        System.out.println(pathSumIII.pathSum(root, 8));
    }

    public int pathSum(TreeNode root, int targetSum) {
        Map<Long, Integer> prefixCount = new HashMap<>();
        prefixCount.put(0L, 1);

        return dfs(root, 0L, targetSum, prefixCount);
    }

    private int dfs(TreeNode node, long currentSum, int targetSum, Map<Long, Integer> prefixCount) {
        if (node == null) return 0;

        currentSum += node.val;

        int count = prefixCount.getOrDefault(currentSum - targetSum, 0);

        prefixCount.merge(currentSum, 1, Integer::sum);

        count += dfs(node.left, currentSum, targetSum, prefixCount);
        count += dfs(node.right, currentSum, targetSum, prefixCount);

        prefixCount.merge(currentSum, -1, Integer::sum);

        return count;
    }
}

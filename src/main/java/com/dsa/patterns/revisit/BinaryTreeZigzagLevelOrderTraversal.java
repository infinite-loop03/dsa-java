package com.dsa.patterns.revisit;

import com.dsa.patterns.trees.TreeNode;

import java.util.*;

public class BinaryTreeZigzagLevelOrderTraversal {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);

        root.left = new TreeNode(9);
        root.right = new TreeNode(20);

        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        BinaryTreeZigzagLevelOrderTraversal binaryTreeZigzagLevelOrderTraversal = new BinaryTreeZigzagLevelOrderTraversal();
        System.out.println(binaryTreeZigzagLevelOrderTraversal.levelOrder(root));
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();

        if (root == null) return result;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        boolean isLeftToRight = false;

        while (!queue.isEmpty()) {
            int levelOrder = queue.size();
            Deque<Integer> deque = new ArrayDeque<>();
            for (int i = 0; i < levelOrder; i++) {
                TreeNode node = queue.poll();

                if (isLeftToRight) {
                    deque.add(node.val);
                } else {
                    deque.addFirst(node.val);
                }

                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
            result.add(new ArrayList<>(deque));
            isLeftToRight = !isLeftToRight;
        }
        return result;
    }
}

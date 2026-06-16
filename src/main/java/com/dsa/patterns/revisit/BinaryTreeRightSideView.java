package com.dsa.patterns.revisit;

import com.dsa.patterns.trees.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeRightSideView {

    public static void main(String[] args) {
        BinaryTreeRightSideView binaryTreeRightSideView = new BinaryTreeRightSideView();
        TreeNode root = new TreeNode(1);

        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        root.left.left = new TreeNode(4);
        root.left.left.left = new TreeNode(5);

        System.out.println(binaryTreeRightSideView.rightSideView(root));
    }

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();

        if (root == null) return result;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()) {
            int level = queue.size();
            int rightElement = 0;
            for (int i = 0; i < level; i++) {
                TreeNode node = queue.poll();

                if (node != null) rightElement = node.val;

                if (node != null && node.left != null) queue.offer(node.left);
                if (node != null && node.right != null) queue.offer(node.right);
            }
            result.add(rightElement);
        }
        return result;
    }
}

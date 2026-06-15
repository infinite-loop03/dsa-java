package com.dsa.patterns.revisit;

import com.dsa.patterns.trees.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class ConstructBinaryTreeFromPreorderAndInorderTraversal {

    public static void main(String[] args) {
        ConstructBinaryTreeFromPreorderAndInorderTraversal constructBinaryTreeFromPreorderAndInorderTraversal = new ConstructBinaryTreeFromPreorderAndInorderTraversal();
        int[] preorder = {3, 9, 20, 15, 7};
        int[] inorder = {9, 3, 15, 20, 7};
        TreeNode.printTree((constructBinaryTreeFromPreorderAndInorderTraversal.buildTree(preorder, inorder)));
    }

    Map<Integer, Integer> inorderToIndex;
    int[] preorder;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder = preorder;
        inorderToIndex = new HashMap<>();

        for (int i = 0; i < inorder.length; i++) {
            inorderToIndex.put(inorder[i], i);
        }
        int[] preorderIndex= {0};
        return createTree(preorderIndex, 0, preorder.length - 1);
    }

    private TreeNode createTree(int[] preorderIndex, int left, int right) {
        if (left > right) return null;

        int rootValue = preorder[preorderIndex[0]++];
        TreeNode root = new TreeNode(rootValue);

        root.left = createTree(preorderIndex, left, inorderToIndex.get(rootValue) - 1);
        root.right = createTree(preorderIndex, inorderToIndex.get(rootValue) + 1, right);

        return root;
    }
}

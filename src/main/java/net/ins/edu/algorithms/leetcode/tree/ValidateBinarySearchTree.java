package net.ins.edu.algorithms.leetcode.tree;

import net.ins.edu.algorithms.leetcode.util.integer.TreeNode;

/**
 * <a href="https://leetcode.com/explore/interview/card/top-interview-questions-easy/94/trees/625/">Validate Binary Search Tree</a>
 */
public class ValidateBinarySearchTree {

    public boolean isValidBST(TreeNode root) {
        return traverseValidating(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean traverseValidating(TreeNode node, long leftVal, long rightVal) {
        if (node == null) return true;

        if (leftVal < node.val && rightVal > node.val) {
            return traverseValidating(node.left, leftVal, node.val) && traverseValidating(node.right, node.val, rightVal);
        }

        return false;
    }

    public static void main(String[] args) {
//        var validBST = new TreeNode(2, new TreeNode(1), new TreeNode(3));
//        System.out.println(new ValidateBinarySearchTree().isValidBST(validBST));
//
//        var invalidBST = new TreeNode(5, new TreeNode(1), new TreeNode(4, new TreeNode(3), new TreeNode(6)));
//        System.out.println(new ValidateBinarySearchTree().isValidBST(invalidBST));

//        var invalidBST2 = new TreeNode(5, new TreeNode(4), new TreeNode(6, new TreeNode(3), new TreeNode(7)));
//        System.out.println(new ValidateBinarySearchTree().isValidBST(invalidBST2));

        var validBST2 = new TreeNode(2147483647);
        System.out.println(new ValidateBinarySearchTree().isValidBST(validBST2));

    }
}

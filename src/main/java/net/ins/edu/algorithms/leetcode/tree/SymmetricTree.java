package net.ins.edu.algorithms.leetcode.tree;

import net.ins.edu.algorithms.leetcode.util.integer.TreeNode;

public class SymmetricTree {

    public boolean isSymmetric(TreeNode root) {
        return areSymmetric(root, root);
    }

    private boolean areSymmetric(TreeNode left, TreeNode right) {
        if (left == null && right == null) return true;

        if (left == null || right == null) return false;

        return left.val == right.val && areSymmetric(left.left, right.right) && areSymmetric(left.right, right.left);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);

        root.left = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);

        root.right = new TreeNode(2);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(3);

        System.out.println(new SymmetricTree().isSymmetric(root));
    }
}

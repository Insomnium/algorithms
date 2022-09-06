package net.ins.edu.algorithms.leetcode.tree;

import net.ins.edu.algorithms.leetcode.util.integer.TreeNode;

/**
 * <a href="https://leetcode.com/explore/interview/card/top-interview-questions-easy/94/trees/555/">Maximum Depth of Binary Tree</a>
 */
public class MaximumDepthOfBinaryTree {

    private int maxDepth = 0;

    public int maxDepth(TreeNode root) {
        traverseDepthCount(root, 1);
        return maxDepth;
    }

    private void traverseDepthCount(TreeNode node, int count) {
        if (node == null) return;

        maxDepth = Math.max(count, this.maxDepth);

        if (node.left != null) {
            traverseDepthCount(node.left, count + 1);
        }

        if (node.right != null) {
            traverseDepthCount(node.right, count + 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(new MaximumDepthOfBinaryTree().maxDepth(null));

        var tree = new TreeNode(3, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7)));
        System.out.println(new MaximumDepthOfBinaryTree().maxDepth(tree));
    }
}

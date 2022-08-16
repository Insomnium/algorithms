package net.ins.edu.algorithms.leetcode.tree;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/binary-tree-inorder-traversal">Binary Tree Inorder Traversal</a>
 */
public class BinaryTreeInorderTraversal {

    public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null) return Collections.emptyList();

        var result = new ArrayList<Integer>();
        traverseNext(root, result);
        return result;
    }

    private void traverseNext(TreeNode node, List<Integer> results) {
        if (node == null) return;

        if (node.left != null)
            traverseNext(node.left, results);

        results.add(node.val); // INORDER. Means all the lefties, then up the tree, traversing upper-right branches.

        if (node.right != null)
            traverseNext(node.right, results);
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static void main(String[] args) {
        var sampleTree = new TreeNode(1, null, new TreeNode(2, new TreeNode(3), null));
        System.out.println(new BinaryTreeInorderTraversal().inorderTraversal(sampleTree));
    }
}

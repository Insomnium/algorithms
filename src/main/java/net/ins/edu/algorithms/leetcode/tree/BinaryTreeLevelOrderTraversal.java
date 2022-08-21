package net.ins.edu.algorithms.leetcode.tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <a href="https://leetcode.com/problems/binary-tree-level-order-traversal">Binary Tree Level Order Traversal</a> *
 */
public class BinaryTreeLevelOrderTraversal {

    private final Map<Integer, List<Integer>> map = new HashMap<>();

    public List<List<Integer>> levelOrder(TreeNode root) {
        traverseOrdered(root, 0);

        var result = new ArrayList<List<Integer>>(map.keySet().size());

        map.keySet().stream().sorted().forEach(level -> {
            List<Integer> levelEntries = map.get(level);
            result.add(new ArrayList<>(levelEntries.size()) {{ addAll(levelEntries); }});
        });

        return result;
    }

    private void traverseOrdered(TreeNode node, int level) {
        if (node == null)
            return;

        if (node.left != null)
            traverseOrdered(node.left, level + 1);

        if (node.right != null)
            traverseOrdered(node.right, level + 1);

        var levelValuesLeftToRight = map.computeIfAbsent(level, integer -> new ArrayList<>());
        levelValuesLeftToRight.add(node.val);
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
        System.out.println(new BinaryTreeLevelOrderTraversal().levelOrder(new TreeNode(3, new TreeNode(9, null, null), new TreeNode(20, new TreeNode(15), new TreeNode(7)))));
        System.out.println(new BinaryTreeLevelOrderTraversal().levelOrder(new TreeNode(1, new TreeNode(2, new TreeNode(4), null), new TreeNode(3, null, new TreeNode(5)))));
    }
}

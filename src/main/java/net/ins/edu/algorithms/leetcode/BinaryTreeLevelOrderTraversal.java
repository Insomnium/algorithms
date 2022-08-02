package net.ins.edu.algorithms.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <a href="https://leetcode.com/problems/binary-tree-level-order-traversal">Binary Tree Level Order Traversal</a> *
 */
public class BinaryTreeLevelOrderTraversal {

    private final Map<Integer, List<Entry>> map = new HashMap<>();

    public List<List<Integer>> levelOrder(TreeNode root) {
        traverseOrdered(root, 0, root);

        var result = new ArrayList<List<Integer>>(map.keySet().size());

        map.keySet().stream().sorted().forEach(level -> {
            List<Entry> levelEntries = map.get(level);

            List<Integer> tmpList = new ArrayList<>(1);
            TreeNode prevParent = null;
            for (Entry entry : levelEntries) {
                if (prevParent == null || entry.parent.val != prevParent.val) {
                    if (!tmpList.isEmpty())
                        result.add(tmpList);
                    tmpList = new ArrayList<>(2);
                }
                tmpList.add(entry.val);
                prevParent = entry.parent;
            }
            if (!tmpList.isEmpty())
                result.add(tmpList);
        });

        return result;
    }

    private void traverseOrdered(TreeNode node, int level, TreeNode parent) {
        if (node == null)
            return;

        if (node.left != null)
            traverseOrdered(node.left, level + 1, node);

        if (node.right != null)
            traverseOrdered(node.right, level + 1, node);

        var levelValuesLeftToRight = map.computeIfAbsent(level, integer -> new ArrayList<>((int) Math.pow(2, level)));
        levelValuesLeftToRight.add(new Entry(parent, node.val));
    }

    private class Entry {
        private TreeNode parent;
        private int val; // TODO: refactor: change to TreeNode for the universality

        public Entry(TreeNode parent, int val) {
            this.parent = parent;
            this.val = val;
        }
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
//        var tree = new TreeNode(3, new TreeNode(9, null, null), new TreeNode(20, new TreeNode(15), new TreeNode(7)));
        var tree = new TreeNode(1, new TreeNode(2, new TreeNode(4), null), new TreeNode(3, null, new TreeNode(5)));
        List<List<Integer>> lists = new BinaryTreeLevelOrderTraversal().levelOrder(tree);
        System.out.println(lists);
    }
}

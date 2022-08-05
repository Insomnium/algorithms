package net.ins.edu.algorithms.leetcode;

import net.ins.edu.algorithms.leetcode.util.AVLNode;
import net.ins.edu.algorithms.leetcode.util.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree">ConvertSortedArrayToBinarySearchTree</a>
 */
public class ConvertSortedArrayToBinarySearchTree {

    public TreeNode<Integer> sortedArrayToBST(Integer[] nums) {
        if (nums.length == 0) return null;
        TreeNode<Integer> root = null;
        for (Integer num : nums) {
            root = insert(root, num);
        }

        return root;
//        sortedArrayToBST(null); // TODO: check if NPE occurs
    }

    private TreeNode<Integer> insert(TreeNode<Integer> node, Integer val) {
        if (node == null) {
            return new TreeNode<>(val);
        }

        if (val.compareTo(node.val) < 0)
            node.left = insert(node.left, val);
        if (val.compareTo(node.val) > 0)
            node.right = insert(node.right, val);

        return node;
    }

    public static void main(String[] args) {

        var avl = new AVLNode<>(10);
        avl = avl.insert(avl, 5);
        avl = avl.insert(avl, 3);
        avl = avl.insert(avl, 2);
        avl = avl.insert(avl, 6);
        avl = avl.insert(avl, 7);
        avl = avl.insert(avl, 20);
        avl = avl.insert(avl, 15);
        avl = avl.insert(avl, 17);
        avl = avl.insert(avl, 30);
        avl = avl.insert(avl, 4);
        avl = avl.insert(avl, 18);
        avl = avl.insert(avl, 19);
        avl = avl.insert(avl, 8);

        avl.visualizeSubtreeLeftToRight();
    }
}

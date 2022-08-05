package net.ins.edu.algorithms.leetcode.util;

import lombok.Getter;

public class AVLNode<T extends Comparable<T>> extends TreeNode<T> {

    public int balanceFactor = 0;
    @Getter
    private int height;

    public AVLNode(T val) {
        super(val);
    }

    public AVLNode(T val, TreeNode<T> left, TreeNode<T> right) {
        super(val, left, right);
    }

    @Override
    public <N extends TreeNode<T>> AVLNode<T> insert(N node, T val) {
        AVLNode<T> avlNode = (AVLNode<T>) node;
        if (avlNode == null) return new AVLNode<>(val);

        if (val.compareTo(node.val) < 0) {
            node.left = insert(node.left, val);
        } else if (val.compareTo(node.val) > 0) {
            node.right = insert(node.right, val);
        }

        return (AVLNode<T>) node;
    }

    @Override
    public String toString() {
        return val.toString() + ":" + balanceFactor;
    }
}

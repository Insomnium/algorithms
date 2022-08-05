package net.ins.edu.algorithms.leetcode.util;

import lombok.Getter;

import static java.lang.Math.max;

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

        // recursive insert (downwards the tree)
        AVLNode<T> n = (AVLNode<T>) super.insert(node, val);

        // recursion ended (going upwards the tree)
        n.height = 1 + max(nodeHeight((AVLNode<T>) n.left), nodeHeight((AVLNode<T>) n.right));
        n.balanceFactor = nodeBalanceFactor(n);

        // left left case
        if (n.balanceFactor > 1 && val.compareTo(n.left.val) < 0) {
            return rightRotate(n);
        }
        // left right case
        if (n.balanceFactor > 1 && val.compareTo(n.left.val) > 0) {
            n.left = leftRotate((AVLNode<T>) n.left);
            return rightRotate(n);
        }

        // right right case
        if (n.balanceFactor < -1 && val.compareTo(n.right.val) > 0) {
            return leftRotate(n);
        }

        // right left case
        if (n.balanceFactor < -1 && val.compareTo(n.right.val) < 0) {
            n.right = rightRotate((AVLNode<T>) n.right);
            return leftRotate(n);
        }

        return n;
    }

    private AVLNode<T> rightRotate(AVLNode<T> y) {
        AVLNode<T> x = (AVLNode<T>) y.left;
        AVLNode<T> T2 = (AVLNode<T>) x.right;

        x.right = y;
        y.left = T2;

        y.height = 1 + max(nodeHeight((AVLNode<T>) y.left), nodeHeight((AVLNode<T>) y.right));
        x.height = 1 + max(nodeHeight((AVLNode<T>) x.left), nodeHeight((AVLNode<T>) x.right));

        x.balanceFactor = nodeBalanceFactor(x);
        y.balanceFactor = nodeBalanceFactor(y);

        return x;
    }

    private AVLNode<T> leftRotate(AVLNode<T> y) {
        AVLNode<T> x = (AVLNode<T>) y.right;
        AVLNode<T> T2 = (AVLNode<T>) x.left;

        x.left = y;
        y.right = T2;

        y.height = 1 + max(nodeHeight((AVLNode<T>) y.left), nodeHeight((AVLNode<T>) y.right));
        x.height = 1 + max(nodeHeight((AVLNode<T>) x.left), nodeHeight((AVLNode<T>) x.right));

        x.balanceFactor = nodeBalanceFactor(x);
        y.balanceFactor = nodeBalanceFactor(y);

        return x;
    }

    private int nodeBalanceFactor(AVLNode<T> node) {
        return node == null ? 0 : (nodeHeight((AVLNode<T>) node.left) - nodeHeight((AVLNode<T>) node.right));
    }

    private int nodeHeight(AVLNode<T> node) {
        return node == null ? 0 : node.height;
    }

    @SuppressWarnings("unchecked")
    @Override
    protected <N extends TreeNode<T>> N createNode(T val) {
        return (N) new AVLNode<>(val);
    }

    @Override
    public String toString() {
        return "%s h:%s bf:%s".formatted(val, height, balanceFactor);
    }
}

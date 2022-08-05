package net.ins.edu.algorithms.leetcode.util;

import lombok.Getter;

import java.io.Serializable;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.BiConsumer;
import java.util.stream.Collectors;

import static java.lang.Math.pow;

//@Getter
public class TreeNode<T extends Comparable<T>> {

    public final T val;
    private TraverseType traverseType = TraverseType.POSTORDER;
    public TreeNode<T> left;
    public TreeNode<T> right;

    public TreeNode(T val) {
        this.val = val;
    }

    public TreeNode(T val, TreeNode<T> left, TreeNode<T> right) {
        this(val);
        this.left = left;
        this.right = right;
    }

    public TreeNode<T> withTraverseType(TraverseType traverseType) {
        this.traverseType = traverseType;
        return this;
    }

//    public <N extends TreeNode<T>> N insert(TreeNode<T> node, T val) {
//        if (node == null) return (N) new TreeNode<>(val);
//        if (val.compareTo(node.val) < 0) {
//            node.left = insert(node.left, val);
//        } else if (val.compareTo(node.val) > 0) {
//            node.right = insert(node.right, val);
//        }
//        return (N) node;
//    }

    public <N extends TreeNode<T>> TreeNode<T> insert(N node, T val) {
        if (node == null) return createNode(val);
        if (val.compareTo(node.val) < 0) {
            node.left = insert(node.left, val);
        } else if (val.compareTo(node.val) > 0) {
            node.right = insert(node.right, val);
        }
        return node;
    }

    @SuppressWarnings("unchecked")
    protected <N extends TreeNode<T>> N createNode(T val) {
        return (N) new TreeNode<>(val);
    }

    public void visualizeSubtreeTopToBottom() {
        withTraverseType(TraverseType.PREORDER);
        AtomicInteger maxDepth = new AtomicInteger(0);
        var elementsByLevels = new LinkedHashMap<Integer, List<TreeNode<T>>>();
        traverse(this, (node, level) -> {
            maxDepth.set(Math.max(maxDepth.get(), level));
            elementsByLevels.computeIfAbsent(level, ArrayList::new).add(node);
        });
        var maxMargin = (maxDepth.incrementAndGet() * 8) / 2;

        elementsByLevels.forEach((level, nodes) -> {
            int elementMargin = (int) (maxMargin / (pow(2, level + 1)));
            System.out.print(" ".repeat(elementMargin));
            var a = nodes.stream().map(Objects::toString).collect(Collectors.joining(" ".repeat(elementMargin)));
            System.out.println(a);
        });
        System.out.println("Max maxDepth = " + maxDepth.get());
    }

    public void visualizeSubtreeLeftToRight() {
        var stringBuilder = new StringBuilder();
        buildLeftToRightTreeRepresentation(stringBuilder, " ", "", this, this.right != null);
        System.out.println(stringBuilder);
    }

    private void traverse(TreeNode<T> root, BiConsumer<TreeNode<T>, Integer> action) {
        traverse(root, 0, action);
    }

    private TreeNode<T> traverse(TreeNode<T> node, int level, BiConsumer<TreeNode<T>, Integer> action) {
        if (node == null) return null;

        if (traverseType == TraverseType.PREORDER) action.accept(node, level);

        if (node.left != null) {
            traverse(node.left, level + 1, action);
        }

        if (traverseType == TraverseType.INORDER) action.accept(node, level);

        if (node.right != null) {
            traverse(node.right, level + 1, action);
        }

        if (traverseType == TraverseType.POSTORDER) action.accept(node, level);

        return node;
    }

    private void buildLeftToRightTreeRepresentation(StringBuilder sb, String padding, String pointer, TreeNode<T> node,
                                                    boolean hasRightSibling) {
        if (node != null) {
            sb.append("\n");
            sb.append(padding);
            sb.append(pointer);
            sb.append(node);

            StringBuilder paddingBuilder = new StringBuilder(padding);
            if (hasRightSibling) {
                paddingBuilder.append("│  ");
            } else {
                paddingBuilder.append("   ");
            }

            String paddingForBoth = paddingBuilder.toString();
            String pointerRight = "└──>";
            String pointerLeft = (node.right != null) ? "├──<" : "└──<";

            buildLeftToRightTreeRepresentation(sb, paddingForBoth, pointerLeft, node.left, node.right != null);
            buildLeftToRightTreeRepresentation(sb, paddingForBoth, pointerRight, node.right, false);
        }
    }

    enum TraverseType {PREORDER, INORDER, POSTORDER}

    @Override
    public String toString() {
        return val.toString();
    }
}

package com.brymanco.datastructures.tree.binary.impl;

import com.brymanco.datastructures.tree.binary.BinaryTree;
import com.brymanco.datastructures.tree.binary.BinaryTreeTraverser;
import java.util.LinkedList;
import java.util.function.Consumer;
import com.brymanco.datastructures.tree.binary.BinaryTreeNode;

public class BreadthFirstBinaryTreeTraverserImpl<T> implements BinaryTreeTraverser<T> {

    private final BinaryTree<T> tree;

    BreadthFirstBinaryTreeTraverserImpl(final BinaryTree<T> tree) {
        this.tree = tree;
    }

    @Override
    public void traverse(final Consumer<BinaryTreeNode<T>> consumer) {
        final LinkedList<BinaryTreeNode<T>> queue = new LinkedList<>();

        if (tree.hasRoot()) {
            queue.add(tree.getRoot());
        }

        while (!queue.isEmpty()) {
            BinaryTreeNode<T> node = queue.poll();

            consumer.accept(node);

            if (node.hasLeft()) {
                queue.add(node.getLeft());
            }

            if (node.hasRight()) {
                queue.add(node.getRight());
            }
        }
    }

}

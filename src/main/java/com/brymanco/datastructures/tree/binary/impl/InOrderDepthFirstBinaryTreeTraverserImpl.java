package com.brymanco.datastructures.tree.binary.impl;

import com.brymanco.datastructures.tree.binary.BinaryTree;
import com.brymanco.datastructures.tree.binary.BinaryTreeTraverser;
import java.util.function.Consumer;
import com.brymanco.datastructures.tree.binary.BinaryTreeNode;

public class InOrderDepthFirstBinaryTreeTraverserImpl<T> implements BinaryTreeTraverser<T> {

    private final BinaryTree<T> tree;

    InOrderDepthFirstBinaryTreeTraverserImpl(final BinaryTree<T> tree) {
        this.tree = tree;
    }

    @Override
    public void traverse(final Consumer<BinaryTreeNode<T>> consumer) {
        traverse(tree.getRoot(), consumer);
    }

    private void traverse(final BinaryTreeNode<T> node, final Consumer<BinaryTreeNode<T>> consumer) {
        if (node != null) {
            traverse(node.getLeft(), consumer);
            consumer.accept(node);
            traverse(node.getRight(), consumer);
        }
    }

}

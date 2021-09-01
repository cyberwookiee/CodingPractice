package com.brymanco.datastructures.tree.binary.impl;

import com.brymanco.datastructures.tree.binary.BinaryTree;
import com.brymanco.datastructures.tree.binary.BinaryTreeFactory;
import com.brymanco.datastructures.tree.binary.BinaryTreeNodeFactory;

public class BinaryTreeFactoryImpl<T> implements BinaryTreeFactory<T> {

    private final BinaryTreeNodeFactory<T, BinaryTreeNodeImpl<T>> factory;

    public BinaryTreeFactoryImpl(final BinaryTreeNodeFactory<T, BinaryTreeNodeImpl<T>> factory) {
        this.factory = factory;
    }

    @Override
    public BinaryTree<T> createBinaryTree() {
        return new BinaryTreeImpl<>(factory);
    }

}

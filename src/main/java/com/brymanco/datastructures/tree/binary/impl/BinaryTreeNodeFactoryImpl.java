package com.brymanco.datastructures.tree.binary.impl;

import com.brymanco.datastructures.tree.binary.BinaryTreeNodeFactory;

public class BinaryTreeNodeFactoryImpl<T> implements BinaryTreeNodeFactory<T, BinaryTreeNodeImpl<T>> {

    @Override
    public BinaryTreeNodeImpl<T> createNode(
            final Object key, T payload,
            final BinaryTreeNodeImpl<T> parent) {
        return new BinaryTreeNodeImpl<>(key, payload, parent);
    }

}

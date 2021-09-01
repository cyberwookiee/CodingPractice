package com.brymanco.datastructures.tree.binary;

public interface BinaryTreeNodeFactory<T, X extends BinaryTreeNode<T>> {

    /**
     *
     * @param key
     * @param payload
     * @param parent
     * @return
     */
    X createNode(
            Object key,
            T payload,
            X parent
    );

}

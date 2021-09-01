package com.brymanco.datastructures.tree.binary;

import java.util.Optional;

/**
 * Represents a binary tree to allow for efficient data storage and retrieval.
 *
 * @author Michael
 * @param <T> The type of the payload.
 */
public interface BinaryTree<T> {

    /**
     * Returns the binary tree root.
     *
     * @return the root of the tree.
     */
    BinaryTreeNode<T> getRoot();

    /**
     *
     * @return
     */
    boolean hasRoot();

    /**
     * Adds the key and payload to the tree.
     *
     * @param key
     * @param payload
     * @return
     */
    boolean add(Object key, T payload);

    /**
     *
     * @param root
     */
    void addTree(BinaryTreeNode<T> root);

    /**
     *
     * @param key
     * @return
     */
    Optional<BinaryTreeNode<T>> remove(Object key);

    /**
     *
     * @param key
     * @return
     */
    boolean contains(Object key);

    /**
     *
     * @param key
     * @return
     */
    Optional<BinaryTreeNode<T>> find(Object key);

    /**
     *
     * @return
     */
    int getSize();

}

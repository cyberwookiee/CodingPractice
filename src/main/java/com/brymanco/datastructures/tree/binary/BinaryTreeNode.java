package com.brymanco.datastructures.tree.binary;

public interface BinaryTreeNode<T> {

    /**
     *
     * @return
     */
    Object getKey();

    /**
     *
     * @return
     */
    T getPayload();

    /**
     *
     * @return
     */
    BinaryTreeNode<T> getLeft();

    /**
     *
     * @return
     */
    BinaryTreeNode<T> getRight();

    /**
     *
     * @return
     */
    boolean hasLeft();

    /**
     *
     * @return
     */
    boolean hasRight();

    /**
     *
     * @return
     */
    boolean isLeaf();

    /**
     *
     * @return
     */
    boolean isRoot();

    /**
     *
     * @param node
     * @return
     */
    boolean isGreaterThan(BinaryTreeNode<T> node);

    /**
     *
     * @param node
     * @return
     */
    boolean isLessThan(BinaryTreeNode<T> node);

    /**
     *
     * @param node
     * @return
     */
    boolean isEqualTo(BinaryTreeNode<T> node);

    /**
     *
     * @param key
     * @return
     */
    boolean isKeyGreaterThan(Object key);

    /**
     *
     * @param key
     * @return
     */
    boolean isKeyLessThan(Object key);

    /**
     *
     * @param key
     * @return
     */
    boolean isKeyEqualTo(Object key);

}

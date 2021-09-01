package com.brymanco.datastructures.tree.binary.impl;

import javax.annotation.Nullable;
import com.brymanco.datastructures.tree.binary.BinaryTreeNode;

public class BinaryTreeNodeImpl<T> implements BinaryTreeNode<T> {

    /**
     *
     */
    private final Object key;

    /**
     *
     */
    private final T payload;

    /**
     *
     */
    private BinaryTreeNodeImpl<T> left;

    /**
     *
     */
    private BinaryTreeNodeImpl<T> right;

    /**
     *
     */
    private final BinaryTreeNodeImpl<T> parent;

    BinaryTreeNodeImpl(final Object key,
            final T payload,
            final BinaryTreeNodeImpl<T> parent) {
        this.key = key;
        this.payload = payload;
        this.parent = parent;
    }

    public BinaryTreeNodeImpl<T> getParent() {
        return parent;
    }

    @Override
    public Object getKey() {
        return key;
    }

    @Override
    public T getPayload() {
        return payload;
    }

    @Override
    public BinaryTreeNodeImpl<T> getLeft() {
        return left;
    }

    @Override
    public BinaryTreeNodeImpl<T> getRight() {
        return right;
    }

    public void setLeft(@Nullable final BinaryTreeNodeImpl<T> left) {
        this.left = left;
    }

    public void setRight(@Nullable final BinaryTreeNodeImpl<T> right) {
        this.right = right;
    }

    @Override
    public boolean isGreaterThan(final BinaryTreeNode<T> node) {
        return this.getKey().hashCode() > node.getKey().hashCode();
    }

    @Override
    public boolean isLessThan(final BinaryTreeNode<T> node) {
        return this.getKey().hashCode() < node.getKey().hashCode();
    }

    @Override
    public boolean isEqualTo(final BinaryTreeNode<T> node) {
        return this.getKey().equals(node.getKey());
    }

    @Override
    public boolean isKeyGreaterThan(final Object key) {
        return this.getKey().hashCode() > key.hashCode();
    }

    @Override
    public boolean isKeyLessThan(final Object key) {
        return this.getKey().hashCode() < key.hashCode();
    }

    @Override
    public boolean isKeyEqualTo(Object o) {
        return this.getKey().equals(o);
    }

    @Override
    public boolean hasLeft() {
        return this.left != null;
    }

    @Override
    public boolean hasRight() {
        return this.right != null;
    }

    @Override
    public boolean isLeaf() {
        return this.right == null && this.left == null;
    }

    @Override
    public boolean isRoot() {
        return this.parent == null;
    }

    @Override
    public String toString() {
        return "NodeImpl{" + "key=" + key + ", left=" + getKey(left) + ", right=" + getKey(right) + ", parent=" + getKey(parent) + '}';
    }

    private String getKey(final BinaryTreeNodeImpl<T> node) {
        return node == null ? "" : node.getKey().toString();
    }

}

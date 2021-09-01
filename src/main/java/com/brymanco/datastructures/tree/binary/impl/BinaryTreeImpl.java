package com.brymanco.datastructures.tree.binary.impl;

import com.brymanco.datastructures.tree.binary.BinaryTree;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;
import org.apache.commons.lang3.mutable.MutableBoolean;
import org.apache.commons.lang3.mutable.MutableObject;
import com.brymanco.datastructures.tree.binary.BinaryTreeNode;
import com.brymanco.datastructures.tree.binary.BinaryTreeNodeFactory;

public class BinaryTreeImpl<T> implements BinaryTree<T> {

    private final BinaryTreeNodeFactory<T, BinaryTreeNodeImpl<T>> factory;

    private final AtomicInteger size;

    BinaryTreeImpl(final BinaryTreeNodeFactory<T, BinaryTreeNodeImpl<T>> factory) {
        this.factory = factory;
        size = new AtomicInteger();
    }

    private BinaryTreeNodeImpl<T> root;

    @Override
    public BinaryTreeNodeImpl<T> getRoot() {
        return root;
    }

    @Override
    public boolean add(final Object key, final T payload) {
        final MutableBoolean added = new MutableBoolean(false);
        this.root = addNode(
                key,
                payload,
                null,
                root,
                added);

        return added.getValue();
    }

    @Override
    public Optional<BinaryTreeNode<T>> remove(final Object key) {
        final MutableObject<BinaryTreeNodeImpl<T>> removed = new MutableObject<>(null);
        this.removeNode(key, root, removed);
        return Optional.ofNullable(removed.getValue());
    }

    @Override
    public boolean contains(final Object key) {
        return this.containsKey(key, root);
    }

    @Override
    public Optional<BinaryTreeNode<T>> find(final Object key) {
        return this.findNode(key, root).flatMap(n -> Optional.of(n));
    }

    private BinaryTreeNodeImpl<T> addNode(
            final Object key,
            final T payload,
            final BinaryTreeNodeImpl<T> parent,
            final BinaryTreeNodeImpl<T> current,
            final MutableBoolean added) {

        if (current == null) {
            this.size.incrementAndGet();
            added.setTrue();

            //   System.out.println("Added " + key.toString() + " to: " + parent);
            return this.factory.createNode(key, payload, parent);
        }

        if (current.isKeyGreaterThan(key)) {
            current.setLeft(
                    addNode(
                            key,
                            payload,
                            current,
                            current.getLeft(),
                            added));
        } else if (current.isKeyLessThan(key)) {
            current.setRight(
                    addNode(
                            key,
                            payload,
                            current,
                            current.getRight(),
                            added));
        }

        return current;

    }

//    private NodeImpl<T> findSmallestNode(final NodeImpl<T> node) {
//        return node.hasLeft() ? findSmallestNode(node.getLeft()) : node;
//    }
//    private NodeImpl<T> removeNode(
//            final NodeImpl<T> current) {
//        if (current.isLeaf()) {
//            return null;
//        } else if (current.hasLeft() && !current.hasRight()) {
//            return current.getLeft();
//        } else if (current.hasRight() && !current.hasLeft()) {
//            return current.getRight();
//        } else {
//            return replaceNode(current);
//        }
//
//    }
//    private NodeImpl<T> replaceNode(final NodeImpl<T> current) {
//        final NodeImpl<T> smallest = this.findSmallestNode(current.getRight());
//        current.set
//                
//                
//                current.value = smallestValue;
//current.right = deleteRecursive(current.right, smallestValue);
//return current;
//
//
//    }
    @Override
    public void addTree(final BinaryTreeNode<T> root) {
        if (root != null) {
            this.add(root.getKey(), root.getPayload());
            addTree(root.getLeft());
            addTree(root.getRight());
        }
    }

    private void removeNode(
            final Object key,
            final BinaryTreeNodeImpl<T> current,
            final MutableObject<BinaryTreeNodeImpl<T>> removed) {

        final Optional<BinaryTreeNodeImpl<T>> node = this.findNode(key, current);

        node.ifPresent(n -> {

            // System.out.println("Removing " + n + " from " + n.getParent());
            removed.setValue(n);

            if (n.isRoot()) {
                this.root = null;
            } else if (n.isLessThan(n.getParent())) {
                n.getParent().setLeft(null);
            } else if (n.isGreaterThan(n.getParent())) {
                n.getParent().setRight(null);
            }

            if (!n.isLeaf()) {
                if (n.hasLeft()) {
                    this.addTree(n.getLeft());
                }

                if (n.hasRight()) {
                    this.addTree(n.getRight());
                }
            }
        });

//        if (current == null) {
//            return;
//        }
//
//        if (current.isKeyEqualTo(key)) {
//            removed.setValue(current);
//            return removeNode(current);
//        } else if (current.isKeyGreaterThan(key)) {
//            current.setLeft(
//                    removeNode(
//                            key,
//                            current.getLeft(),
//                            removed));
//        } else if (current.isKeyLessThan(key)) {
//            current.setRight(
//                    removeNode(
//                            key,
//                            current.getLeft(),
//                            removed));
//        }
//
//        return current;
    }

    private boolean containsKey(
            final Object key,
            final BinaryTreeNodeImpl<T> current) {
        if (current == null) {
            return false;
        }

        if (current.isKeyGreaterThan(key)) {
            return containsKey(
                    key,
                    current.getLeft());
        } else if (current.isKeyLessThan(key)) {
            return containsKey(
                    key,
                    current.getRight());
        } else {
            return true;
        }

    }

    private Optional<BinaryTreeNodeImpl<T>> findNode(
            final Object key,
            final BinaryTreeNodeImpl<T> current) {
        if (current == null) {
            return Optional.empty();
        }

        if (current.isKeyGreaterThan(key)) {
            return findNode(
                    key,
                    current.getLeft());
        } else if (current.isKeyLessThan(key)) {
            return findNode(
                    key,
                    current.getRight());
        } else {
            return Optional.of(current);
        }

    }

    @Override
    public String toString() {
        return "BinaryTreeImpl{" + "root=" + root + '}';
    }

    @Override
    public int getSize() {
        return this.size.get();
    }

    @Override
    public boolean hasRoot() {
        return this.root != null;
    }

}

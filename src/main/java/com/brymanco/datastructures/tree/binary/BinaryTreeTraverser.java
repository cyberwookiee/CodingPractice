package com.brymanco.datastructures.tree.binary;

import java.util.function.Consumer;

public interface BinaryTreeTraverser<T> {

    void traverse(Consumer<BinaryTreeNode<T>> consumer);

}

package com.brymanco.datastructures.tree.binary;

public interface BinaryTreeTraverserFactory {

    <T> BinaryTreeTraverser createBreadthFirstTraverser(BinaryTree<T> tree);

    <T> BinaryTreeTraverser createInOrderDepthFirstTraverser(BinaryTree<T> tree);

    <T> BinaryTreeTraverser createPreOrderDepthFirstTraverser(BinaryTree<T> tree);

    <T> BinaryTreeTraverser createPostOrderDepthFirstTraverser(BinaryTree<T> tree);

}

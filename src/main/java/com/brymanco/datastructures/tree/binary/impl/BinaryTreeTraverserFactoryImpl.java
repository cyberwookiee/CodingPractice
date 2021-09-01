package com.brymanco.datastructures.tree.binary.impl;

import com.brymanco.datastructures.tree.binary.BinaryTree;
import com.brymanco.datastructures.tree.binary.BinaryTreeTraverser;
import com.brymanco.datastructures.tree.binary.BinaryTreeTraverserFactory;

public class BinaryTreeTraverserFactoryImpl implements BinaryTreeTraverserFactory {

    @Override
    public <T> BinaryTreeTraverser createBreadthFirstTraverser(BinaryTree<T> tree) {
        return new BreadthFirstBinaryTreeTraverserImpl(tree);
    }

    @Override
    public <T> BinaryTreeTraverser createInOrderDepthFirstTraverser(BinaryTree<T> tree) {
        return new InOrderDepthFirstBinaryTreeTraverserImpl(tree);
    }

    @Override
    public <T> BinaryTreeTraverser createPreOrderDepthFirstTraverser(BinaryTree<T> tree) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public <T> BinaryTreeTraverser createPostOrderDepthFirstTraverser(BinaryTree<T> tree) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}

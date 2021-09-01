package com.brymanco.test;

import com.brymanco.datastructures.tree.binary.BinaryTree;
import com.brymanco.datastructures.tree.binary.BinaryTreeFactory;
import com.brymanco.datastructures.tree.binary.BinaryTreeTraverser;
import com.brymanco.datastructures.tree.binary.BinaryTreeTraverserFactory;
import com.brymanco.datastructures.tree.binary.impl.BinaryTreeFactoryImpl;
import com.brymanco.datastructures.tree.binary.impl.BinaryTreeTraverserFactoryImpl;
import com.brymanco.datastructures.tree.binary.impl.BinaryTreeNodeFactoryImpl;
import com.brymanco.datastructures.tree.binary.impl.BinaryTreeNodeImpl;
import java.util.Optional;
import java.util.Random;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import com.brymanco.datastructures.tree.binary.BinaryTreeNode;
import com.brymanco.datastructures.tree.binary.BinaryTreeNodeFactory;

public class BinaryTreesTest {

    private BinaryTree<String> createBinaryTree() {
        System.out.println("Creating Tree");

        final BinaryTreeNodeFactory<String, BinaryTreeNodeImpl<String>> nodeFactory = new BinaryTreeNodeFactoryImpl<>();

        final BinaryTreeFactory<String> treeFactory = new BinaryTreeFactoryImpl(nodeFactory);

        final BinaryTree<String> tree = treeFactory.createBinaryTree();

        return tree;
    }

    private void verifyTree(BinaryTree<?> tree) {
        System.out.println("Verifying Tree");

        if (tree.getRoot() != null) {
            verifyTreeNode(tree.getRoot());
        }
    }

    private void verifyTreeNode(BinaryTreeNode node) {
        if (node.getLeft() != null) {
            Assertions.assertTrue(node.isGreaterThan(node.getLeft()));
            verifyTreeNode(node.getLeft());
        }

        if (node.getRight() != null) {
            Assertions.assertTrue(node.isLessThan(node.getRight()));
            verifyTreeNode(node.getRight());
        }
    }

    private void populateTree(BinaryTree<String> tree) {
        System.out.println("Populating Tree");

        final Random rand = new Random();

        int total = 0;

        for (int ii = 0; ii < 10_000; ii++) {
            int x = rand.nextInt(10_000);
            if (tree.add(x, "Test" + x)) {
                total++;
            }
        }

        Assertions.assertEquals(total, tree.getSize());

        System.out.println(tree);

    }

    void removeFromTree(BinaryTree tree, BinaryTreeNode node) {
        System.out.println("Removing From Tree");

        tree.remove(node.getKey());
    }

    @Test
    public void verifyTreeRemoval() throws InterruptedException {

        final BinaryTree<String> tree = createBinaryTree();

        Assertions.assertNotNull(tree);

        populateTree(tree);

        verifyTree(tree);

        BinaryTreeNode<String> toRemove = tree.getRoot().getLeft().getRight().getLeft();

        Assertions.assertTrue(tree.contains(toRemove.getKey()));

        Assertions.assertFalse(tree.contains(-1));

        Assertions.assertFalse(tree.find(-1).isPresent());

        Optional<BinaryTreeNode<String>> node = tree.find(toRemove.getKey());

        Assertions.assertTrue(node.isPresent());

        removeFromTree(tree, tree.getRoot());

        removeFromTree(tree, toRemove);

        removeFromTree(tree, tree.getRoot().getLeft().getRight());

        verifyTree(tree);

    }

    @Test
    public void verifyInOrderTraversal() throws InterruptedException {

        final BinaryTree<String> tree = createBinaryTree();

        populateTree(tree);

        verifyTree(tree);

        BinaryTreeTraverserFactory factory = new BinaryTreeTraverserFactoryImpl();

        BinaryTreeTraverser<String> traverser = factory.createInOrderDepthFirstTraverser(tree);

        traverser.traverse(node -> {
            System.out.println(node);
        });

    }

    @Test
    public void verifyBreadthFirstTraversal() throws InterruptedException {

        final BinaryTree<String> tree = createBinaryTree();

        populateTree(tree);

        verifyTree(tree);

        BinaryTreeTraverserFactory factory = new BinaryTreeTraverserFactoryImpl();

        BinaryTreeTraverser<String> traverser = factory.createBreadthFirstTraverser(tree);

        traverser.traverse(node -> {
            System.out.println(node);
        });

    }

}

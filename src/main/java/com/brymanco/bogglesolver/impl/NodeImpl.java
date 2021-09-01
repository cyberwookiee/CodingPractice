package com.brymanco.bogglesolver.impl;

import com.brymanco.bogglesolver.Node;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.TreeSet;

public class NodeImpl implements Node {

    private boolean isWord;

    private final NodeImpl[] nextNodes;

    private final NodeImpl previous;

    private final char letter;

    public NodeImpl(
            final char letter,
            final boolean isWord,
            final NodeImpl previous) {
        this.isWord = isWord;
        this.letter = letter;
        this.nextNodes = new NodeImpl[26];
        this.previous = previous;
    }

    @Override
    public boolean isWord() {
        return isWord;
    }

    @Override
    public char getLetter() {
        return letter;
    }

    private int toIndex(char c) {
        return c - 97;
    }

    private void addNextNode(final NodeImpl node) {
        this.nextNodes[toIndex(node.getLetter())] = node;
    }

    private NodeImpl addNext(final char c, final boolean isWord, final NodeImpl previous) {

        if (this.nextNodes[toIndex(c)] != null) {
            this.nextNodes[toIndex(c)].isWord |= isWord;
            return this.nextNodes[toIndex(c)];
        }

        final NodeImpl node = new NodeImpl(c, isWord, previous);
        addNextNode(node);
        return node;
    }

    private void doAddWord(final String word) {
        if (word != null && !word.isEmpty()) {
            final NodeImpl next = addNext(
                    word.charAt(0),
                    word.length() == 1,
                    this);
            next.doAddWord(word.substring(1));
        }
    }

    public void addWord(final String word) {
        if (word.length() >= 1) {
            this.doAddWord(word);
        }
    }

    @Override
    public boolean nextIncludes(char c) {
        return this.nextNodes[toIndex(c)] != null;
    }

    @Override
    public String getWord() {
        if (previous == null) {
            return Character.toString(letter);
        } else {
            return previous.getWord() + Character.toString(letter);
        }
    }

    @Override
    public boolean hasNext() {
        for (int ii = 0; ii < nextNodes.length; ii++) {
            if (nextNodes[ii] != null) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Set<Character> getNextChars() {
        final Set<Character> chars = new TreeSet<>();

        for (int ii = 0; ii < nextNodes.length; ii++) {
            if (nextNodes[ii] != null) {
                chars.add(nextNodes[ii].getLetter());
            }
        }

        return chars;

    }

    @Override
    public Optional< Node> getNext(char c) {
        return Optional.ofNullable(this.nextNodes[toIndex(c)]);
    }

    @Override
    public List<Node> getNextNodes() {

        final List<Node> nodes = new LinkedList<>();

        for (int ii = 0; ii < nextNodes.length; ii++) {
            if (nextNodes[ii] != null) {
                nodes.add(nextNodes[ii]);
            }
        }

        return nodes;

    }

}

package com.brymanco.strings.impl;

import com.brymanco.bogglesolver.Dictionary;
import com.brymanco.bogglesolver.Node;
import com.brymanco.strings.IStringSplitter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class StringSplitter implements IStringSplitter {

    private final Dictionary dictionary;

    public StringSplitter(final Dictionary dictionary) {
        this.dictionary = dictionary;
    }

    @Override
    public List<String> splitString(final String userInput) {

        final List<String> options = new ArrayList<>();

        doSplitString(userInput, options, "");

        return options;
    }

    public void doSplitString(final String userInput, final List<String> options, final String path) {

        StringBuilder sb = new StringBuilder();

        Optional<Node> currNode = Optional.of(dictionary);

        for (int ii = 0; ii < userInput.length(); ii++) {
            final char c = userInput.charAt(ii);

            sb.append(c);

            currNode = currNode.get().getNext(c);

            if (currNode.isPresent()) {
                if (currNode.get().isWord()) {
                    doSplitString(userInput.substring(ii + 1), options, path + sb.toString() + " ");
                }
            } else {
                break;
            }

        }

        if (currNode.isPresent() && currNode.get().isWord()) {
            options.add(path + sb.toString());
        }

    }

}

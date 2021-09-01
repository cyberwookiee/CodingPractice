package com.brymanco.bogglesolver;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface Node {

    char getLetter();

    Set<Character> getNextChars();

    List<Node> getNextNodes();

    String getWord();

    boolean hasNext();

    boolean isWord();

    boolean nextIncludes(char c);

    Optional<Node> getNext(char c);

}

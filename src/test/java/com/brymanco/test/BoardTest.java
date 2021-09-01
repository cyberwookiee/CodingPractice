package com.brymanco.test;

import com.brymanco.bogglesolver.Board;
import com.brymanco.bogglesolver.BoardGenerator;
import com.brymanco.bogglesolver.BoardSolver;
import com.brymanco.bogglesolver.Dictionary;
import com.brymanco.bogglesolver.DictionaryLoader;
import com.brymanco.bogglesolver.impl.BoardGeneratorImpl;
import com.brymanco.bogglesolver.impl.DepthFirstRecursiveTrieDictionarySolver;
import com.brymanco.bogglesolver.impl.DictionaryLoaderImpl;
import java.net.URL;
import java.util.Set;
import org.junit.jupiter.api.Test;

public class BoardTest {

    @Test
    public void givenDictionarySolveBoggleBoards() {
        try {
            final BoardGenerator generator = new BoardGeneratorImpl();

            final DictionaryLoader loader = new DictionaryLoaderImpl();

            final URL wordsUrl = this.getClass().getResource("/words.txt");

            System.out.println("Loading dictionary...");

            final Dictionary dictionary = loader.load(wordsUrl.toURI());

            System.out.println("...Done Loading dictionary.");

            final BoardSolver solver = new DepthFirstRecursiveTrieDictionarySolver();

            for (int ii = 0; ii < 10; ii++) {
                final Board board = generator.generate(5);

                final Set<String> words = solver.solve(board, dictionary);

                if (words.size() > 0) {
                    System.out.println(board.toString());

                    for (final String word : words) {
                        System.out.println(word);
                    }
                }

            }
        } catch (Throwable t) {
            t.printStackTrace();
        }

    }

}

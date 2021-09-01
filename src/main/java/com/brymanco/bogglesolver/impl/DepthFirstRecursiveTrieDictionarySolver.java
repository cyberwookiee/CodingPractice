package com.brymanco.bogglesolver.impl;

import com.brymanco.bogglesolver.Board;
import com.brymanco.bogglesolver.BoardSolver;
import com.brymanco.bogglesolver.Dictionary;
import com.brymanco.bogglesolver.Node;
import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

public class DepthFirstRecursiveTrieDictionarySolver implements BoardSolver {

    @Override
    public Set<String> solve(
            final Board board,
            final Dictionary dictionary) {

        final Set<String> solutions = new TreeSet<>();

        for (int xx = 0; xx < board.getRowLength(); xx++) {
            for (int yy = 0; yy < board.getRowLength(); yy++) {
                buildSolutionSet(
                        xx,
                        yy,
                        new boolean[board.getRowLength()][board.getRowLength()],
                        dictionary,
                        board,
                        solutions);
            }
        }

        return solutions;
    }

    private void buildSolutionSet(
            int xx,
            int yy,
            final boolean[][] visited,
            final Node node,
            final Board board,
            final Set<String> solutions) {

        if (node.isWord()) {
            final String word = node.getWord();

            if (word.length() > 3) {
                solutions.add(node.getWord());
            }
        }

        if (xx >= 0 && yy >= 0 && xx < board.getRowLength() && yy < board.getRowLength()) {
            if (!visited[xx][yy]) {

                visited[xx][yy] = true;

                final char c = board.getCharAtPosition(xx, yy);

                node.getNext(c).ifPresent(n -> {
                    buildSolutionSet(xx - 1, yy - 1, copyArray(visited, board), n, board, solutions);
                    buildSolutionSet(xx - 1, yy, copyArray(visited, board), n, board, solutions);
                    buildSolutionSet(xx, yy - 1, copyArray(visited, board), n, board, solutions);
                    buildSolutionSet(xx + 1, yy - 1, copyArray(visited, board), n, board, solutions);
                    buildSolutionSet(xx - 1, yy + 1, copyArray(visited, board), n, board, solutions);
                    buildSolutionSet(xx + 1, yy + 1, copyArray(visited, board), n, board, solutions);
                    buildSolutionSet(xx + 1, yy, copyArray(visited, board), n, board, solutions);
                    buildSolutionSet(xx, yy + 1, copyArray(visited, board), n, board, solutions);
                });
            }
        }
    }

    private static boolean[][] copyArray(boolean[][] visited, Board board) {
        return Arrays.copyOfRange(visited, 0, board.getRowLength());
    }
}

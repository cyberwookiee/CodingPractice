package com.brymanco.bogglesolver.impl;

import com.brymanco.bogglesolver.Board;

public class BoardImpl implements Board {

    private char[][] board;
    private final int rowLength;

    public BoardImpl(final String chars, final int rowLength) {

        if (rowLength * rowLength != chars.length()) {
            throw new IllegalArgumentException("square of rowLength (" + rowLength + "): " + rowLength * rowLength + " does not equal chars length: " + chars.length());
        }

        this.rowLength = rowLength;
        board = new char[rowLength][rowLength];

        for (int ii = 0; ii < rowLength; ii++) {
            for (int jj = 0; jj < rowLength; jj++) {
                board[ii][jj] = chars.charAt((ii * rowLength) + jj);
            }
        }
    }

    @Override
    public String toString() {
        return "BoardImpl{" + boardToString() + '}';
    }

    private String boardToString() {
        final StringBuilder sb = new StringBuilder();

        sb.append(System.lineSeparator());

        for (int ii = 0; ii < rowLength; ii++) {
            for (int jj = 0; jj < rowLength; jj++) {
                sb.append(board[ii][jj]).append(" ");
            }
            sb.append(System.lineSeparator());
        }
        return sb.toString();
    }

    @Override
    public int getRowLength() {
        return rowLength;
    }

    @Override
    public char getCharAtPosition(int xx, int yy) {
        return this.board[xx][yy];
    }

}

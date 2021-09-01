package com.brymanco.bogglesolver;

import java.util.Set;

public interface BoardSolver {

    Set<String> solve(Board board, Dictionary dictionary);
}

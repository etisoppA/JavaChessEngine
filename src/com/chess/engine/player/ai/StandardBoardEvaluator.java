package com.chess.engine.player.ai;

import com.chess.engine.board.Board;
import com.chess.engine.pieces.Piece;
import com.chess.engine.player.Player;

public class StandardBoardEvaluator implements BoardEvaluator {
    @Override
    public int evaluate(Board board, int depth) {
        return scorePlayer(board, board.whitePlayer(), depth) - scorePlayer(board, board.blackPlayer(), depth);
    }

    private int scorePlayer(Board board, Player player, int depth) {
        return pieceValue(player);
    }

    private static int pieceValue(final Player player) {
        int pieceValueScore = 0;
        for (final Piece piece : player.getActivePieces()) {
            pieceValueScore += piece.getPieceValue();
        }
        return pieceValueScore;
    }


}
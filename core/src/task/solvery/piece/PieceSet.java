package task.solvery.piece;

import task.solvery.board.ColumnName;
import task.solvery.piece.set.*;

public enum PieceSet {
    BLACK_KING(new King(Piece.Color.BLACK, new Position(ColumnName.E, 8))),
    BLACK_QUEEN(new Queen(Piece.Color.BLACK, new Position(ColumnName.D, 8))),
    BLACK_LEFT_ROOK(new Rook(Piece.Color.BLACK, new Position(ColumnName.A, 8))),
    BLACK_RIGHT_ROOK(new Rook(Piece.Color.BLACK, new Position(ColumnName.H, 8))),
    BLACK_RIGHT_BISHOP(new Bishop(Piece.Color.BLACK, new Position(ColumnName.F, 8))),
    BLACK_LEFT_BISHOP(new Bishop(Piece.Color.BLACK, new Position(ColumnName.C, 8))),
    BLACK_RIGHT_KNIGHT(new Knight(Piece.Color.BLACK, new Position(ColumnName.G, 8))),
    BLACK_LEFT_KNIGHT(new Knight(Piece.Color.BLACK, new Position(ColumnName.B, 8))),
    BLACK_PAWN_1(new Pawn(Piece.Color.BLACK, new Position(ColumnName.A, 7))),
    BLACK_PAWN_2(new Pawn(Piece.Color.BLACK, new Position(ColumnName.B, 7))),
    BLACK_PAWN_3(new Pawn(Piece.Color.BLACK, new Position(ColumnName.C, 7))),
    BLACK_PAWN_4(new Pawn(Piece.Color.BLACK, new Position(ColumnName.D, 7))),
    BLACK_PAWN_5(new Pawn(Piece.Color.BLACK, new Position(ColumnName.E, 7))),
    BLACK_PAWN_6(new Pawn(Piece.Color.BLACK, new Position(ColumnName.F, 7))),
    BLACK_PAWN_7(new Pawn(Piece.Color.BLACK, new Position(ColumnName.G, 7))),
    BLACK_PAWN_8(new Pawn(Piece.Color.BLACK, new Position(ColumnName.H, 7))),
    WHITE_KING(new King(Piece.Color.WHITE, new Position(ColumnName.E, 1))),
    WHITE_QUEEN(new Queen(Piece.Color.WHITE, new Position(ColumnName.D, 1))),
    WHITE_LEFT_ROOK(new Rook(Piece.Color.WHITE, new Position(ColumnName.A, 1))),
    WHITE_RIGHT_ROOK(new Rook(Piece.Color.WHITE, new Position(ColumnName.H, 1))),
    WHITE_RIGHT_BISHOP(new Bishop(Piece.Color.WHITE, new Position(ColumnName.F, 1))),
    WHITE_LEFT_BISHOP(new Bishop(Piece.Color.WHITE, new Position(ColumnName.C, 1))),
    WHITE_RIGHT_KNIGHT(new Knight(Piece.Color.WHITE, new Position(ColumnName.G, 1))),
    WHITE_LEFT_KNIGHT(new Knight(Piece.Color.WHITE, new Position(ColumnName.B, 1))),
    WHITE_PAWN_1(new Pawn(Piece.Color.WHITE, new Position(ColumnName.A, 2))),
    WHITE_PAWN_2(new Pawn(Piece.Color.WHITE, new Position(ColumnName.B, 2))),
    WHITE_PAWN_3(new Pawn(Piece.Color.WHITE, new Position(ColumnName.C, 2))),
    WHITE_PAWN_4(new Pawn(Piece.Color.WHITE, new Position(ColumnName.D, 2))),
    WHITE_PAWN_5(new Pawn(Piece.Color.WHITE, new Position(ColumnName.E, 2))),
    WHITE_PAWN_6(new Pawn(Piece.Color.WHITE, new Position(ColumnName.F, 2))),
    WHITE_PAWN_7(new Pawn(Piece.Color.WHITE, new Position(ColumnName.G, 2))),
    WHITE_PAWN_8(new Pawn(Piece.Color.WHITE, new Position(ColumnName.H, 2)));

    private final Piece piece;

    PieceSet(Piece piece) {
        this.piece = piece;
    }

    public Piece getPiece() {
        return piece;
    }
}

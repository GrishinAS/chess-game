package model.board;

import model.ColumnName;
import model.MoveType;
import model.Position;
import model.piece.Piece;
import model.piece.set.Rook;

import java.util.HashMap;
import java.util.Map;

import static model.piece.Piece.Color.BLACK;
import static model.piece.Piece.Color.WHITE;

public class Board {
    private Field field;

    public Board(Field field) {
        this.field = field;
        arrangePieces();
    }

    public void move(Position moveFrom, Position moveTo) {
        Piece movingPiece = field.getPiece(moveFrom);
        if (movingPiece == null)
            throw new IllegalArgumentException("Empty field: " + moveFrom);

        // check move is possible for chosen figure
        MoveType moveType = movingPiece.validateMove(moveTo, field);
        if (moveType == MoveType.ILLEGAL)
            throw new IllegalArgumentException("move is impossible");

        field.setPiecePosition(movingPiece, moveTo);
        field.setPiecePosition(null, moveFrom);

        if (movingPiece.isNowCheckForOpponent(field))
            field.setCheck(true);
    }

    private void arrangePieces() {
        Map<Piece, Position> startPositions = createStartPositions();
        for (Piece piece : startPositions.keySet()) {
            Position position = startPositions.get(piece);
            field.setPiecePosition(piece, position);
        }
    }

    private Map<Piece, Position> createStartPositions() {
        Map<Piece, Position> piecePositionMap = new HashMap<>();
        piecePositionMap.put(new Rook(BLACK), new Position(ColumnName.A, 1));
        piecePositionMap.put(new Rook(BLACK), new Position(ColumnName.H, 1));
        piecePositionMap.put(new Rook(WHITE), new Position(ColumnName.A, 8));
        piecePositionMap.put(new Rook(WHITE), new Position(ColumnName.H, 8));
        return piecePositionMap;
    }
}

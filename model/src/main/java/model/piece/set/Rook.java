package model.piece.set;

import model.ColumnName;
import model.MoveType;
import model.Position;
import model.board.Field;
import model.piece.Piece;

import java.util.Objects;
import java.util.function.Function;

import static model.piece.Piece.Color.getOppositeColor;

public class Rook implements Piece {

    private final Color pieceColor;
    private Position position;

    public Rook(Color pieceColor) {
        this.pieceColor = pieceColor;
    }

    @Override
    public Color getPieceColor() {
        return pieceColor;
    }

    @Override
    public Position getPosition() {
        return position;
    }

    @Override
    public void setPosition(Position position) {
        this.position = position;
    }

    @Override
    public boolean isNowCheckForOpponent(Field field) {
        Piece opponentsKing = field.findPiece(King.class, getOppositeColor(pieceColor));
        return validateMove(Objects.requireNonNull(opponentsKing, "King is not found").getPosition(), field) == MoveType.ATTACK;
    }

    @Override
    public MoveType validateMove(Position moveTo, Field field) {
        // check that two positions are on the same row/column
        if (correctMove(moveTo) &&
                // check that no pieces in the way ( on the row or column)
                emptyPath(moveTo, field) &&
                // check that no check situation?
                validateCheck(moveTo, field)) {
            // check if there is a piece on the final position, check if it's the same color as current piece. Illegal if yes, attack if no.
            Piece finalDestPiece = field.getPiece(moveTo);
            if (finalDestPiece != null && finalDestPiece.getPieceColor() != pieceColor)
                return MoveType.ATTACK;
            else if (finalDestPiece == null)
                return MoveType.MOVE;
        }
        return MoveType.ILLEGAL;
    }

    private boolean validateCheck(Position moveTo, Field field) {
        Piece teammateKing = field.findPiece(King.class, pieceColor);
        // todo check also that this move will not create check situation on your king
        // check all opponent's pieces that the not attack our king after this move??
        return !field.isCheck();
    }

    private boolean emptyPath(Position moveTo, Field field) {
        if (position.getRow() != moveTo.getRow()) {
            int rowFrom = Math.min(position.getRow(), moveTo.getRow());
            int rowTo = Math.max(position.getRow(), moveTo.getRow());
            return searchWayForPieces(i -> new Position(moveTo.getColumnName(), i), field, rowFrom, rowTo);
        } else {
            int fromColumn = position.getColumnNumber();
            int toColumn = moveTo.getColumnNumber();
            return searchWayForPieces(i -> new Position(ColumnName.values()[i], moveTo.getRow()), field, fromColumn, toColumn);
        }
    }

    private boolean searchWayForPieces(Function<Integer, Position> positionSupplier, Field field, int from, int to) {
        int less;
        int bigger;
        if (from > to) {
            less = to;
            bigger = from - 1;
        } else {
            bigger = to;
            less = from + 1;
        }
        for (int i = less; i < bigger; i++) {
            if (field.getPiece(positionSupplier.apply(i)) != null) {
                return false;
            }
        }
        return true;
    }

    private boolean correctMove(Position moveTo) {
        if (position.equals(moveTo)) {
            return false;
        }
        return position.getRow() == moveTo.getRow() ||
                position.getColumnName() == moveTo.getColumnName();
    }
}

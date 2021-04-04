package model.piece.set;

import model.MoveType;
import model.Position;
import model.board.Field;
import model.piece.Piece;

import java.util.Objects;

import static model.piece.Piece.Color.getOppositeColor;

public class King implements Piece {
    private final Color pieceColor;
    private Position position;

    public King(Color pieceColor) {
        this.pieceColor = pieceColor;
    }

    @Override
    public MoveType validateMove(Position moveTo, Field field) {
        // check that two positions are on the same diagonal
        if (emptyPath(moveTo, field) &&
            correctMove(moveTo)) {
            Piece finalDestPiece = field.getPiece(moveTo);
            if (finalDestPiece != null && finalDestPiece.getPieceColor() != pieceColor)
                return MoveType.ATTACK;
            else if (finalDestPiece == null)
                return MoveType.MOVE;
        }

        // check that no check situation
        // check if there is a piece on the final position, check if it's the same color as current piece. Illegal if yes, attack if no.
        return MoveType.ILLEGAL;
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
    public Color getPieceColor() {
        return pieceColor;
    }

    private boolean emptyPath(Position moveTo, Field field) {
        return field.getPiece(moveTo) == null;
    }

    private boolean correctMove(Position moveTo) {
        if (position.equals(moveTo)) {
            return false;
        }
        // разница между старым и новым рядом равна разнице между старым и новым column
        return Math.abs(position.getRow() - moveTo.getRow()) ==
                Math.abs(position.getColumnNumber() - moveTo.getColumnNumber());
    }


}

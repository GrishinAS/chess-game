package model.piece.set;

import model.ColumnName;
import model.MoveType;
import model.Position;
import model.board.Field;
import model.piece.Piece;

import java.util.Objects;

import static model.piece.Piece.Color.*;

public class Bishop implements Piece {
    private final Color pieceColor;
    private Position position;

    public Bishop(Color pieceColor) {
        this.pieceColor = pieceColor;
    }

    @Override
    public MoveType validateMove(Position moveTo, Field field) {
        if (emptyPath(moveTo, field) &&
                validateCheck(moveTo, field) &&
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

    private boolean validateCheck(Position moveTo, Field field) {
        Piece teammateKing = field.findPiece(King.class, pieceColor);
        // todo check also that this move will not create check situation on your king
        // check all opponent's pieces that the not attack our king after this move??
        return !field.isCheck();
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
        int currentColumn = position.getColumnNumber();
        int currentRow = position.getRow();
        while (currentColumn != moveTo.getColumnNumber() && currentRow != moveTo.getRow()) {
            if (currentColumn > moveTo.getColumnNumber())
                currentColumn --;
            else
                currentColumn ++;
            if (currentRow > moveTo.getRow())
                currentRow --;
            else
                currentRow ++;
            if (field.getPiece(new Position(ColumnName.values()[currentColumn], currentRow)) != null) {
                return false;
            }
        }
        return true;
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

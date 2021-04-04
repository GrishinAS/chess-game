package model.board;

import model.Position;
import model.piece.Piece;
import org.jetbrains.annotations.Nullable;

public class Field {
    private Piece[][] pieces = new Piece[8][8];
    private boolean check = false;

    public Piece getPiece(Position position) {
        return pieces[position.getColumnNumber()][position.getRow() - 1];
    }

    @Nullable
    public Piece findPiece(Class<? extends Piece> type, Piece.Color color) {
        for (Piece[] row : pieces) {
            for (Piece piece : row) {
                if (piece != null && piece.getClass().equals(type) && piece.getPieceColor() == color) {
                    return piece;
                }
            }
        }
        return null;
    }

    public void setPiecePosition(@Nullable Piece piece, Position position) {
        if (piece != null)
            piece.setPosition(position);
        pieces[position.getColumnNumber()][position.getRow() - 1] = piece;
    }

    public boolean isCheck() {
        return check;
    }

    public void setCheck(boolean check) {
        this.check = check;
    }
}

package model.piece;

import model.MoveType;
import model.Position;
import model.board.Field;

public interface Piece {

    MoveType validateMove(Position moveTo, Field field);

    Color getPieceColor();

    Position getPosition();

    void setPosition(Position position);

    boolean isNowCheckForOpponent(Field field);

    enum Color {
        WHITE,
        BLACK;

        public static Color getOppositeColor(Color pieceColor) {
            if (pieceColor == BLACK) {
                return WHITE;
            }
            else {
                return BLACK;
            }
        }
    }
}

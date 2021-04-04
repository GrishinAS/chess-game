package model.piece.set;

import model.ColumnName;
import model.MoveType;
import model.Position;
import model.board.Field;
import model.piece.Piece;
import org.junit.jupiter.api.Test;

import static model.piece.Piece.Color.BLACK;
import static model.piece.Piece.Color.WHITE;
import static org.junit.jupiter.api.Assertions.*;

class BishopTest {

    @Test
    public void validateMoveCheckFailOtherPieceInPath() {
        Piece bishop = new Bishop(BLACK);
        Rook obstruction = new Rook(WHITE);
        Field field = new Field();

        field.setPiecePosition(bishop, new Position(ColumnName.D, 4));
        field.setPiecePosition(obstruction, new Position(ColumnName.B, 6));

        MoveType moveType = bishop.validateMove(new Position(ColumnName.A, 7), field);

        assertEquals(MoveType.ILLEGAL, moveType);
    }

    @Test
    public void validateMoveCheckFailWrongPath() {
        Piece bishop = new Bishop(BLACK);
        Field field = new Field();

        field.setPiecePosition(bishop, new Position(ColumnName.D, 4));

        MoveType moveType = bishop.validateMove(new Position(ColumnName.F, 4), field);

        assertEquals(MoveType.ILLEGAL, moveType);
    }

    @Test
    public void validateMoveCheckSuccess() {
        Piece bishop = new Bishop(BLACK);
        Field field = new Field();
        Rook obstruction = new Rook(WHITE);

        field.setPiecePosition(bishop, new Position(ColumnName.D, 4));
        field.setPiecePosition(obstruction, new Position(ColumnName.H, 8));

        MoveType moveType = bishop.validateMove(new Position(ColumnName.G, 7), field);

        assertEquals(MoveType.MOVE, moveType);
    }
}
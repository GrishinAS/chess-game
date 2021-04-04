package model.piece.set;

import model.ColumnName;
import model.MoveType;
import model.Position;
import model.board.Field;
import model.piece.Piece;
import org.junit.jupiter.api.Test;

import static model.piece.Piece.Color.*;
import static org.junit.jupiter.api.Assertions.*;

class RookTest {
    @Test
    public void validateMoveCheckFail() {
        Piece rook = new Rook(BLACK);
        Field field = new Field();
        field.setPiecePosition(rook, new Position(ColumnName.D, 5));
        field.setPiecePosition(new Bishop(WHITE), new Position(ColumnName.G, 5));
        MoveType moveType = rook.validateMove(new Position(ColumnName.H, 4), field);
        assertEquals(moveType, MoveType.ILLEGAL);
    }

    @Test
    public void validateMoveCheckSuccess() {
        Piece rook = new Rook(BLACK);
        Field field = new Field();
        field.setPiecePosition(rook, new Position(ColumnName.D, 5));
        MoveType moveType = rook.validateMove(new Position(ColumnName.H, 5), field);
        assertEquals(MoveType.MOVE, moveType);
    }
}
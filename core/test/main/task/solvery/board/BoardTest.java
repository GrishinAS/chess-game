package task.solvery.board;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BoardTest {

  @Test
  void testSuccessfulTableInit() {
    Board board = new Board();
    Square[][] squares = board.getSquares();

  }
}
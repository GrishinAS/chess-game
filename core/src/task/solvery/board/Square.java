package task.solvery.board;

import task.solvery.piece.Piece;
import task.solvery.piece.Position;

public class Square {
  private final Position position;
  private final Color color;
  private Piece currentPiece;

  public Square(ColumnName columnName, int row, Color color) {
    this.position = new Position(columnName, row);
    this.color = color;
  }

  public Position getPosition() {
    return position;
  }

  public Color getColor() {
    return color;
  }

  public Piece getCurrentPiece() {
    return currentPiece;
  }

  public void setCurrentPiece(Piece currentPiece) {
    this.currentPiece = currentPiece;
  }

  enum Color {
    WHITE,
    BLACK
  }
}



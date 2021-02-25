package task.solvery.board;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import task.solvery.piece.Piece;
import task.solvery.piece.PieceSet;
import task.solvery.piece.Position;

public class Board extends Actor {
  private final Square[][] squares = new Square[8][8]; // column, row
  private final TextureAtlas textureAtlas;
  private final Stage stage;

  public Board(TextureAtlas textureAtlas, Stage stage) {
    this.textureAtlas = textureAtlas;
    this.stage = stage;
    initField();
    initPieces();
  }

  public Square[][] getSquares() {
    return squares;
  }

  @Override
  public void draw(Batch batch, float parentAlpha) {
    batch.draw(new Texture("chessboard.png"), 0, 0);
  }

  private void initPieces() {
    for (PieceSet piece : PieceSet.values()) {
      Piece pieceInstance = piece.getPiece();
      Position position = pieceInstance.getPosition();
      squares[position.getColumnName().ordinal()][position.getRow() - 1].setCurrentPiece(pieceInstance);
      pieceInstance.setTextureAtlas(textureAtlas);
      stage.addActor(pieceInstance);
      stage.addActor(this);
    }
  }

  private void initField() {
    for (int column = 0; column < squares.length; column++) {
      Square[] rows = squares[column];
      for (int row = 1; row <= rows.length; row++) {
        rows[row - 1] = new Square(ColumnName.values()[column], row, getSquareColor(column, row));
      }
    }
  }

  private Square.Color getSquareColor(int column, int row) {
    if ((column % 2 + row % 2) % 2 == 0) {
      return Square.Color.BLACK;
    }
    else
      return Square.Color.WHITE;
  }
}

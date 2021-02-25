package task.solvery.piece;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.Actor;

public abstract class Piece extends Actor {
    public static final int PIECE_WIDTH = 40;
    public static final int PIECE_HEIGHT = 65;

    private final Color sideColor;
    private TextureAtlas textureAtlas;
    private Position position;

    public Piece(Color color, Position position) {
        this.sideColor = color;
        this.position = position;
    }

    public Color getSideColor() {
        return sideColor;
    }

    public Position getPosition() {
        return position;
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        String pieceName = getClass().getName().substring(getClass().getName().lastIndexOf(".") + 1);
        TextureAtlas.AtlasRegion region = textureAtlas.findRegion((pieceName + "_" + getSideColor()).toLowerCase()); // TODO Replace by getting from enum
        batch.draw(region, position.getX(), position.getY(), PIECE_WIDTH, PIECE_HEIGHT);
    }

    protected abstract void move();

    public void setTextureAtlas(TextureAtlas textureAtlas) {
        this.textureAtlas = textureAtlas;
    }

    public enum Color {
        WHITE,
        BLACK
    }
}

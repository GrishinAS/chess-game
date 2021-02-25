package task.solvery;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import task.solvery.board.Board;

public class ChessGame extends Game {
    static public Skin skin;
    private  BoardScreen boardScreen;

    @Override
    public void create() {
        boardScreen = new BoardScreen();
        setScreen(boardScreen);
    }

    @Override
    public void render() {
        super.render();

    }

    public void dispose() {
        boardScreen.dispose();
    }
}
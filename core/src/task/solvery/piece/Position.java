package task.solvery.piece;

import task.solvery.board.ColumnName;

public class Position {
    private ColumnName columnName;
    private int row;
    private static final int INDENT_FROM_SCREEN_BORDER = 48;
    private static final int INDENT_FROM_BOARD_BORDER = 20;
    private static final int INDENT_FROM_PIECE = 81;

    public Position(ColumnName columnName, int row) {
        this.columnName = columnName;
        this.row = row;
    }

    public ColumnName getColumnName() {
        return columnName;
    }

    public int getRow() {
        return row;
    }

    public int getX() {
        return INDENT_FROM_SCREEN_BORDER + INDENT_FROM_BOARD_BORDER + (INDENT_FROM_PIECE * columnName.ordinal());
    }

    public int getY() {
        return INDENT_FROM_SCREEN_BORDER + INDENT_FROM_BOARD_BORDER + ((8 - row) * INDENT_FROM_PIECE);
    }
}

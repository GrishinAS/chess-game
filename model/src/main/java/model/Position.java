package model;

public class Position {
    private ColumnName columnName;
    private int row;

    public Position(ColumnName columnName, int row) {
        this.columnName = columnName;
        this.row = row;
    }

    public ColumnName getColumnName() {
        return columnName;
    }

    public int getColumnNumber() {
        return columnName.ordinal();
    }

    public int getRow() {
        return row;
    }

    @Override
    public String toString() {
        return "Position{" +
                "columnName=" + columnName +
                ", row=" + row +
                '}';
    }
}

//Конь
public class Horse extends ChessPiece {
    public Horse(String color) {
        super(color);
    }

    @Override
    public String getColor() {
        return color;
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        int distLine = Math.abs(toLine - line);
        int distColumn = Math.abs(toColumn - column);
        if ((line == toLine) && (column == toColumn)) {
            return false;
        }
        if (((0 <= toLine) && (toLine < 8)) && ((0 <= toColumn) && (toColumn < 8))) {
            if (((distLine == 2) && (distColumn == 1)) || ((distLine == 1) && (distColumn == 2))) {
                if (chessBoard.board[toLine][toColumn] == null) {
                    return true;
                } else {
                    return !chessBoard.board[toLine][toColumn].getColor().equals(color);
                }
            } else return false;
        } else return false;
    }

    @Override
    public String getSymbol() {
        return "H";
    }
}
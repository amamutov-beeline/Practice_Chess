//Пешка
public class Pawn extends ChessPiece {
    public Pawn(String color) {
        super(color);
    }

    @Override
    public String getColor() {
        return color;
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        int distLine = toLine - line;
        if (column == toColumn) {
            if (((0 <= toLine) && (toLine < 8)) && ((0 <= toColumn) && (toColumn < 8))) {
                if (chessBoard.board[toLine][toColumn] != null) {
                    return false;
                }
                if (line == toLine) {
                    return false;
                } else if (color.equals("White")) {
                    if ((line == 1) && (distLine == 2)) {
                        return true;
                    } else if (distLine == 1) {
                        return true;
                    } else return false;
                } else if (color.equals("Black")) {
                    if ((line == 6) && (distLine == -2)) {
                        return true;
                    } else if (distLine == -1) {
                        return true;
                    } else return false;
                } else return false;
            } else return false;
        } else {
            if ((column - toColumn == 1 || column - toColumn == -1) && (line - toLine == 1 || line - toLine == -1)) {
                return !chessBoard.board[toLine][toColumn].getColor().equals(color);
            } else return false;
        }
    }

    @Override
    public String getSymbol() {
        return "P";
    }
}

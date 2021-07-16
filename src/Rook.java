public class Rook extends ChessPiece {
    public Rook(String color) {
        super(color);
    }

    @Override
    public String getColor() {
        return this.color;
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        if (chessBoard.checkPos(line) && chessBoard.checkPos(column) && chessBoard.checkPos(toLine) && chessBoard.checkPos(toColumn)) {
            if (column == toColumn) {
                for (int i = Math.min(line, toLine); i < Math.min(line, toLine); i++) {
                    if (chessBoard.board[i][column] != null) {
                        if (chessBoard.board[i][column] == this && i == Math.min(line, toLine)) return false;
                        else if (chessBoard.board[i][column].getColor().equals(this.color) && i == toLine)
                            return false;
                        else if (!chessBoard.board[i][column].getColor().equals(this.color) && i == toLine)
                            return true;
                        else if (i != toLine && i != line) return false;
                    }
                }
                if (chessBoard.board[toLine][column] != null) {
                    if (chessBoard.board[toLine][column].getColor().equals(this.color) && chessBoard.board[toLine][column] != this)
                        return false;
                    else return !chessBoard.board[toLine][column].getColor().equals(this.color) && chessBoard.board[toLine][column] != this;
                } else return true;

            } else if (line == toLine) {

                for (int i = Math.min(toColumn, column); i < Math.min(column, toColumn); i++) {
                    if (chessBoard.board[line][i] != null) {
                        if (chessBoard.board[line][i] == this && i == Math.min(column, toColumn)) return false;
                        else if (chessBoard.board[line][i].getColor().equals(this.color) && i == toColumn)
                            return false;
                        else if (!chessBoard.board[line][i].getColor().equals(this.color) && i == toColumn)
                            return true;
                        else if (i != toLine && i != column) return false;
                    }
                }
                if (chessBoard.board[toLine][toColumn] != null) {
                    if (chessBoard.board[toLine][toColumn].getColor().equals(this.color) && chessBoard.board[toLine][toColumn] != this)
                        return false;
                    else return !chessBoard.board[toLine][toColumn].getColor().equals(this.color) && chessBoard.board[toLine][toColumn] != this;
                } else return true;
            } else return false;
        } else return false;
    }

    @Override
    public String getSymbol() {
        return "R";
    }
}


//Ладья
/*public class Rook extends ChessPiece {

    public Rook(String color) {
        super(color);
    }

    @Override
    public String getColor() {
        return color;
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        int distLine = line - toLine;
        int distColumn = column - toColumn;
        if (((0 <= toLine) && (toLine < 8)) && ((0 <= toColumn) && (toColumn < 8))) {
            if (column == toColumn) {
                if (line == toLine) {
                    return false;
                } else if (distLine > 0) {
                    for (int i = line; i >= toLine; i--) {
                        if (chessBoard.board[i][column] != null) {
                            return false;
                        } else return true;
                    }
                } else if (distLine < 0) {
                    for (int i = toLine; i >= line; i++) {
                        if (chessBoard.board[i][column] != null) {
                            return false;
                        } else return true;
                    }
                } else return false;
            } else if (line == toLine) {
                if (distColumn > 0) {
                    for (int i = column; i >= toColumn; i--) {
                        if (chessBoard.board[line][i] != null) {
                            return false;
                        } else return true;
                    }
                } else if (distColumn < 0) {
                    for (int i = toColumn; i >= column; i++) {
                        if (chessBoard.board[line][i] != null) {
                            return false;
                        } else return true;
                    }
                } else return false;
            } else return false;
        } else return false;
    }

    @Override
    public String getSymbol() {
        return "R";
    }
}
 */

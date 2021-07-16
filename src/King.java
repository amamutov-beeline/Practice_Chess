public class King extends ChessPiece{
    public King(String color) {
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

        if (line == toLine && column == toColumn){
            return false;
        }
        if (((0 <= toLine) && (toLine < 8)) && ((0 <= toColumn) && (toColumn < 8))) {
            if (distLine <= 1 && distColumn <= 1){
                if (chessBoard.board[toLine][toColumn] == null){
                    return true;
                }
                else {
                    return !chessBoard.board[toLine][toColumn].getColor().equals(color);
                }
            }else return false;
        }else return false;
    }

    @Override
    public String getSymbol() {
        return "K";
    }

    public boolean isUnderAttack(ChessBoard chessBoard, int line, int column) {
        if (chessBoard.checkPos(line) && chessBoard.checkPos(column)) {
            for (int i = 0; i < 7; i++) {
                for (int j = 0; j < 7; j++) {
                    if (chessBoard.board[i][j] != null) {
                        if (!chessBoard.board[i][j].getColor().equals(color) && chessBoard.board[i][j].canMoveToPosition(chessBoard, i, j, line, column)) {
                            return true;
                        }
                    }
                }
            }
            return false;
        } else return false;
    }
}

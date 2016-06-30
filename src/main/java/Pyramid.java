/**
 * Created by Eric on 16/6/30.
 */
public class Pyramid {
    private Board board = new Board();

    public Board getBoard() {
        return board;
    }

    public boolean put(Piece piece, int col, int row) {
        return board.put(piece, col, row);
    }

    public void print() {
        board.print();
    }
}

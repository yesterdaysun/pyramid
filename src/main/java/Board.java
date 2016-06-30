import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

/**
 * Created by Eric on 16/6/30.
 */
public class Board {
    private List<List<Cell>> cells = new ArrayList<>();

    public Board() {
        for (int row = 0; row < 10; row++) {
            List<Cell> cellRow = new ArrayList<>();
            for (int col = 0; col < 10 - row; col++) {
                cellRow.add(new Cell(col, row));
            }
            cells.add(cellRow);
        }
    }

    public void eachCell(Consumer<Cell> consumer) {
        cells.forEach((row) -> row.forEach(consumer::accept));
    }

    public Cell getCell(int col, int row) {
        return cells.get(row).get(col);
    }

    public boolean put(Piece piece, int col, int row) {
        if (piece.getPoints().stream().allMatch((point) -> isValid(col + point.getX(), row + point.getY()))) {
            putWithoutCheck(piece, col, row);
            return true;
        } else {
            return false;
        }
    }

    private void putWithoutCheck(Piece piece, int col, int row) {
        Point offset = new Point(col, row);
        piece.getPoints().stream()
                .map((point -> point.move(offset)))
                .forEach((point) -> cells.get(point.getY()).get(point.getX()).setPieceNumber(piece.getPieceNumber()));
    }

    private boolean isValid(int col, int row) {
        if (0 <= row && row < cells.size()) {
            List<Cell> cellRow = this.cells.get(row);
            if (0 <= col && col < cellRow.size()) {
                return cellRow.get(col).getPieceNumber() == 0;
            }
        }
        return false;
    }
}

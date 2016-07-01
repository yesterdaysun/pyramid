import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

/**
 * Created by Eric on 16/6/30.
 */
public class Board {
    public static final Map<Integer, String> PieceCodes = new HashMap<Integer, String>() {{
        put(0, "_");
        put(1, "A");
        put(2, "B");
        put(3, "C");
        put(4, "D");
        put(5, "E");
        put(6, "F");
        put(7, "G");
        put(8, "H");
        put(9, "I");
        put(10, "J");
        put(11, "K");
        put(12, "L");
    }};

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

    public void print() {
        for (int i = 0; i < 10; i++) {
            for (int k = 0; k < (10 - i) * 2; k++) {
                System.out.print(" ");
            }
            for (int j = 0; j <= i; j++) {
                System.out.print(String.format(" %s  ", PieceCodes.get(cells.get(i - j).get(j).getPieceNumber())));
            }
            System.out.println();
        }
    }

    public List<Boolean> buildStateList(boolean isStart) {
        List<Boolean> result = new ArrayList<>();
        for (int i = 0; i < 68; i++) {
            result.add(false);
        }
        if (isStart) {
            result.set(0, true);
        }
        return result;

    }
}

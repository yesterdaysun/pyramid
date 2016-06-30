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
}

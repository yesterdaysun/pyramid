import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

    public Set<Step> solve() {
        HashSet<Step> steps = new HashSet<>();

        List<Piece> pendingPieces = new ArrayList<>();
        findMissingPieceNumbers().forEach(number -> pendingPieces.addAll(Piece.PieceMap.get(number)));
        board.buildStateList(true);

        return steps;
    }

    private List<Integer> findMissingPieceNumbers() {
        boolean[] used = new boolean[13];
        board.eachCell(cell -> used[cell.getPieceNumber()] = true);

        List<Integer> missing = new ArrayList<>();
        for (int i = 0; i < 13; i++) {
            if (!used[i]) {
                missing.add(i);
            }
        }
        return missing;
    }
}

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

    public boolean put(Step step) {
        return board.put(step.getPiece(), step.getCol(), step.getRow());
    }

    public void print() {
        board.print();
    }

    public Set<Step> solve() {
        HashSet<Step> steps = new HashSet<>();

        List<Piece> pendingPieces = new ArrayList<>();
        findMissingPieceNumbers().forEach(number -> pendingPieces.addAll(Piece.PieceMap.get(number)));

        List<List<Boolean>> stateMatrix = new ArrayList<>();
        ArrayList<Step> solutionList = new ArrayList<>();
        stateMatrix.add(board.buildStateList(true));
        solutionList.add(new Step(null, 0, 0));
        pendingPieces.forEach((piece) -> {
            for (int col = 0; col < 10; col++) {
                for (int row = 0; row < 10 - col; row++) {
                    Board draftBoard = new Board();
                    if (draftBoard.put(piece, col, row)) {
                        stateMatrix.add(draftBoard.buildStateList(false));
                        solutionList.add(new Step(piece, col, row));
                    }
                }
            }
        });

        DancingLink dancingLink = new DancingLink(stateMatrix);
        Set<Integer> answers = dancingLink.getAnswers();
        answers.remove(0);
        answers.forEach(answer -> steps.add(solutionList.get(answer)));

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

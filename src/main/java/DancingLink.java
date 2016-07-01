import java.util.*;
import java.util.function.Consumer;

/**
 * Created by Eric on 16/6/30.
 */
public class DancingLink {
    private ColumnDancingNode head;
    private Stack<DancingNode> answers = new Stack<>();

    public DancingLink(List<List<Boolean>> input) {
        head = new ColumnDancingNode(-1);
        List<ColumnDancingNode> columns = new ArrayList<>();

        if (input.size() > 0) {
            int len = input.get(0).size();
            DancingNode current = head;
            for (int i = 0; i < len; i++) {
                ColumnDancingNode next = new ColumnDancingNode(i);
                columns.add(next);
                current.appendRight(next);
                current = next;
            }

            for (int row = input.size() - 1; row >= 0; row--) {
                List<Boolean> cellRow = input.get(row);
                current = null;
                for (int col = 0; col < len; col++) {
                    if (cellRow.get(col)) {
                        DancingNode next = new DancingNode(col, row);
                        ColumnDancingNode head = columns.get(col);
                        head.appendDown(next);
                        next.setHead(head);
                        if (current != null) {
                            current.appendRight(next);
                        }
                        current = next;
                    }
                }
            }
        }
    }

    public Set<Integer> getAnswers() {
        return getAnswers(ignore -> {
        });
    }

    public Set<Integer> getAnswers(Consumer<List<Integer>> consumer) {
        solve(consumer);
        Set<Integer> result = new HashSet<>();
        while (!answers.empty()) {
            result.add(answers.pop().getRow());
        }
        return result;
    }

    private boolean solve(Consumer<List<Integer>> consumer) {
        if (head.emptyInRow()) {
            return true;
        }
        ColumnDancingNode processColumn = findTopPriorityColumn();
        if (processColumn.emptyInCol()) {
            return false;
        }
        List<DancingNode> candidate = processColumn.remove();
        for (DancingNode node : candidate) {
            answers.push(node);
            consumer.accept(buildAnswers());

            Stack<DancingNode> conflict = new Stack<>();
            node.eachColWithoutThis((colNode) -> {
                conflict.push(colNode.getHead());
                colNode.getHead().remove();
            });
            if (solve(consumer)) {
                return true;
            } else {
                while (!conflict.empty()) {
                    conflict.pop().rollback();
                }
                answers.pop();
//                consumer.accept(buildAnswers());
            }
        }
        processColumn.rollback();
        return false;
    }

    private ColumnDancingNode findTopPriorityColumn() {
        ColumnDancingNode nextCol = (ColumnDancingNode) head.getRight();
        ColumnDancingNode minColumn = nextCol;
        while (nextCol != head) {
            if (minColumn.getCount() > nextCol.getCount()) {
                minColumn = nextCol;
            }
            nextCol = (ColumnDancingNode) nextCol.getRight();
        }
        return minColumn;
    }

    private List<Integer> buildAnswers() {
        List<Integer> result = new ArrayList<>();
        answers.forEach(answer -> result.add(answer.getRow()));
        return result;
    }
}



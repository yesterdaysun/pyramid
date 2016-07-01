import java.util.*;

/**
 * Created by Eric on 16/6/30.
 */
public class DancingLink {
    private ColumnDancingNode head;
    private Stack<DancingNode> answers = new Stack<>();
    private final List<ColumnDancingNode> columns;

    public DancingLink(List<List<Boolean>> input) {
        head = new ColumnDancingNode(-1);
        columns = new ArrayList<>();

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
        solve();
        Set<Integer> result = new HashSet<>();
        while (!answers.empty()) {
            result.add(answers.pop().getRow());
        }
        return result;
    }

    private boolean solve() {
        if (head.empty()) {
            return true;
        }
        ColumnDancingNode nextCol = (ColumnDancingNode) head.getRight();
        ColumnDancingNode minColumn = nextCol;
        while (nextCol != head) {
            if (minColumn.getCount() > nextCol.getCount()) {
                minColumn = nextCol;
            }
            nextCol = (ColumnDancingNode) nextCol.getRight();
        }

        nextCol = minColumn;
        DancingNode nextRow = nextCol.getDown();
        if (nextRow == nextCol) {
            return false;
        }
        Stack<DancingNode> candidate = nextCol.remove();
        for (DancingNode node : candidate) {
            answers.push(node);

            Stack<DancingNode> conflict = new Stack<>();
            node.eachCol((colNode) -> {
                if (colNode.getHead() != node.getHead()) {
                    conflict.push(colNode.getHead());
                    colNode.getHead().remove();
                }
            });
            if (solve()) {
                return true;
            } else {
                while (!conflict.empty()) {
                    DancingNode conflictNode = conflict.pop();
                    conflictNode.rollback();
                }
                answers.pop();
            }
        }
        nextCol.rollback();
        return false;
    }
}



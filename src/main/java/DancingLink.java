import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by Eric on 16/6/30.
 */
public class DancingLink {
    private DancingNode head;
    private List<DancingNode> columns;
    private Stack<DancingNode> answers = new Stack<>();

    public DancingLink(List<List<Boolean>> input) {
        head = new DancingNode();
        columns = new ArrayList<>();

        if (input.size() > 0) {
            int len = input.get(0).size();
            DancingNode current = head;
            for (int i = 0; i < len; i++) {
                DancingNode next = new DancingNode();
                columns.add(next);
                current.appendRight(next);
                current = next;
            }

            for (int row = 0; row < input.size(); row++) {
                List<Boolean> cellRow = input.get(row);
                current = null;
                for (int col = 0; col < len; col++) {
                    if (cellRow.get(col)) {
                        DancingNode next = new DancingNode(col, row);
                        columns.get(col).appendDown(next);
                        if (current != null) {
                            current.appendRight(next);
                        }
                        current = next;
                    }
                }
            }
        }
    }

    public List<Integer> getAnswer() {
        solve();
        ArrayList<Integer> result = new ArrayList<>();
        for (DancingNode node : answers) {
            result.add(node.getRow());
        }
        return result;
    }

    private boolean solve() {
        DancingNode nextCol = head.getRight();
        if (nextCol == head) {
            return true;
        }
        DancingNode nextRow = nextCol.getDown();
        if (nextRow == nextCol) {
            return false;
        }
        Stack<DancingNode> candidate = nextCol.remove();
        for (DancingNode node : candidate) {
            answers.push(node);

            Stack<DancingNode> conflict = new Stack<>();
            node.eachCol((colNode) -> {
                conflict.push(colNode.getHead());
                colNode.getHead().remove();
            });
            if (solve()) {
                return true;
            } else {
                while (!conflict.empty()){
                    DancingNode conflictNode = conflict.pop();
                    conflictNode.rollback();
                }
                answers.pop();
            }
        }
        return false;
    }
}



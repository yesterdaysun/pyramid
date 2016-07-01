import lombok.Data;

import java.util.Stack;
import java.util.function.Consumer;

@Data
public class DancingNode {
    protected ColumnDancingNode head;
    protected DancingNode up;
    protected DancingNode down;
    protected DancingNode left;
    protected DancingNode right;
    protected int col;
    protected int row;

    public DancingNode() {
        this(-1, -1);
    }

    public DancingNode(int col, int row) {
        this.col = col;
        this.row = row;
        setLeft(this);
        setRight(this);
        setUp(this);
        setDown(this);
    }

    @Override
    public String toString() {
        return String.format("%d %d", col + 1, row + 1);
    }

    public boolean empty() {
        return getRight() == this;
    }

    public void appendRight(DancingNode node) {
        DancingNode next = getRight();
        setRight(node);
        next.setLeft(node);
        node.setLeft(this);
        node.setRight(next);
    }

    public void appendDown(DancingNode node) {
        DancingNode next = getDown();
        setDown(node);
        next.setUp(node);
        node.setUp(this);
        node.setDown(next);
    }

    public void eachRow(Consumer<DancingNode> consumer) {
        DancingNode next = getDown();
        while (next != this) {
            consumer.accept(next);
            next = next.getDown();
        }
    }

    public void eachCol(Consumer<DancingNode> consumer) {
        DancingNode next = getRight();
        while (next != this) {
            consumer.accept(next);
            next = next.getRight();
        }
    }

    public Stack<DancingNode> remove() {
        Stack<DancingNode> result = new Stack<>();
        removeFromRow();
        eachRow((node) -> {
            result.push(node);
            node.eachCol(DancingNode::removeFromCol);
        });
        return result;
    }

    public void removeFromRow() {
        DancingNode previous = getLeft();
        DancingNode next = getRight();
        previous.setRight(next);
        next.setLeft(previous);
    }

    public void rollbackInRow() {
        DancingNode previous = getLeft();
        DancingNode next = getRight();
        previous.setRight(this);
        next.setLeft(this);
    }

    public void removeFromCol() {
        DancingNode previous = getUp();
        DancingNode next = getDown();
        previous.setDown(next);
        next.setUp(previous);
        getHead().decrease();
    }

    public void rollbackInCol() {
        DancingNode previous = getUp();
        DancingNode next = getDown();
        previous.setDown(this);
        next.setUp(this);
        getHead().increase();
    }

    public void rollback() {
        rollbackInRow();
        eachRow((node) -> {
            node.eachCol(DancingNode::rollbackInCol);
        });
    }
}

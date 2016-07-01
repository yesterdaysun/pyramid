import lombok.Data;

import java.util.ArrayList;
import java.util.List;
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

    public boolean emptyInRow() {
        return getRight() == this;
    }

    public boolean emptyInCol() {
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

    public void eachRowWithoutThis(Consumer<DancingNode> consumer) {
        DancingNode next = getDown();
        while (next != this) {
            consumer.accept(next);
            next = next.getDown();
        }
    }

    public void eachColWithoutThis(Consumer<DancingNode> consumer) {
        DancingNode next = getRight();
        while (next != this) {
            consumer.accept(next);
            next = next.getRight();
        }
    }

    public List<DancingNode> remove() {
        List<DancingNode> result = new ArrayList<>();
        removeFromRow();
        eachRowWithoutThis((node) -> {
            result.add(node);
            node.eachColWithoutThis(DancingNode::removeFromCol);
        });
        return result;
    }

    public void rollback() {
        rollbackInRow();
        eachRowWithoutThis((node) -> {
            node.eachColWithoutThis(DancingNode::rollbackInCol);
        });
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
}

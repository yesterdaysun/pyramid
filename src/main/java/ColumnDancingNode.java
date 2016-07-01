import lombok.Data;

/**
 * Created by Eric on 16/7/1.
 */
@Data
public class ColumnDancingNode extends DancingNode {
    private int count = 0;

    public ColumnDancingNode(int col) {
        super(col, -1);
    }

    public void increase() {
        count++;
    }

    public void decrease() {
        count--;
    }

    @Override
    public void appendDown(DancingNode node) {
        super.appendDown(node);
        increase();
    }

    @Override
    public String toString() {
        return String.format("C%d", col + 1);
    }
}

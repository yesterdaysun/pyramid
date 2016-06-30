import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

/**
 * Created by Eric on 16/6/30.
 */
public class Piece {
    private int pieceNumber;
    private List<Point> points;

    public Piece(int pieceNumber, Point... points) {
        this.pieceNumber = pieceNumber;
        this.points = Arrays.asList(points);
    }

    public int getPieceNumber() {
        return pieceNumber;
    }

    public void eachPoint(Consumer<Point> consumer) {
        points.forEach(consumer);
    }
}

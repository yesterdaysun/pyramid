import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by Eric on 16/6/30.
 */
public class TestPiece {
    @Test
    public void create_a_empty_piece() {
        Piece piece = new Piece(1);

        assertEquals(1, piece.getPieceNumber());
    }

    @Test
    public void create_one_point_piece() {
        Piece piece = new Piece(1, new Point(2, 3));

        piece.eachPoint((point) -> {
            assertEquals(2, point.getX());
            assertEquals(3, point.getY());
        });
    }

    @Test
    public void create_2_point_piece() {
        Piece piece = new Piece(1, new Point(1, 3), new Point(2, 2));

        List<Point> points = new ArrayList<>();
        piece.eachPoint(points::add);

        assertEquals(2, points.size());

        assertEquals(1, points.get(0).getX());
        assertEquals(3, points.get(0).getY());

        assertEquals(2, points.get(1).getX());
        assertEquals(2, points.get(1).getY());
    }
}

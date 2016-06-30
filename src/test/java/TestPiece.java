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
            assertPoint(2, 3, point);
        });
    }

    @Test
    public void create_2_point_piece() {
        Piece piece = new Piece(1, new Point(1, 3), new Point(2, 2));

        List<Point> points = new ArrayList<>();
        piece.eachPoint(points::add);

        assertEquals(2, points.size());
        assertPoint(1, 3, points.get(0));
        assertPoint(2, 2, points.get(1));
    }

    @Test
    public void create_a_predefined_piece() {
        Piece piece = Piece.A1;

        List<Point> points = new ArrayList<>();
        piece.eachPoint(points::add);

        assertEquals(Piece.TYPE_A, piece.getPieceNumber());
        assertEquals(4, points.size());

        assertPoint(2, 0, points.get(0));
        assertPoint(0, 1, points.get(1));
        assertPoint(1, 1, points.get(2));
        assertPoint(2, 1, points.get(3));
    }

    @Test
    public void create_a_rotate_piece() {
        Piece piece = Piece.A2;

        List<Point> points = new ArrayList<>();
        piece.eachPoint(points::add);

        assertEquals(Piece.TYPE_A, piece.getPieceNumber());
        assertEquals(4, points.size());

        assertPoint(1, 2, points.get(0));
        assertPoint(0, 0, points.get(1));
        assertPoint(0, 1, points.get(2));
        assertPoint(0, 2, points.get(3));
    }

    @Test
    public void create_a_rotate_180_piece() {
        Piece piece = Piece.A3;

        List<Point> points = new ArrayList<>();
        piece.eachPoint(points::add);

        assertEquals(Piece.TYPE_A, piece.getPieceNumber());
        assertEquals(4, points.size());

        assertPoint(0, 1, points.get(0));
        assertPoint(2, 0, points.get(1));
        assertPoint(1, 0, points.get(2));
        assertPoint(0, 0, points.get(3));
    }

    @Test
    public void create_a_flip_piece() {
        Piece piece = Piece.A5;

        List<Point> points = new ArrayList<>();
        piece.eachPoint(points::add);

        assertEquals(Piece.TYPE_A, piece.getPieceNumber());
        assertEquals(4, points.size());

        assertPoint(2, 1, points.get(0));
        assertPoint(0, 0, points.get(1));
        assertPoint(1, 0, points.get(2));
        assertPoint(2, 0, points.get(3));
    }

    private void assertPoint(int expectedX, int expectedY, Point point) {
        assertEquals(expectedX, point.getX());
        assertEquals(expectedY, point.getY());
    }
}

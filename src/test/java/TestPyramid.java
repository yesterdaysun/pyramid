import org.junit.Test;

import java.util.concurrent.atomic.AtomicInteger;

import static junit.framework.TestCase.assertFalse;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by Eric on 16/6/30.
 */
public class TestPyramid {
    private final Pyramid pyramid = new Pyramid();

    @Test
    public void empty_pyramid_should_have_55_empty_cells() {
        AtomicInteger count = new AtomicInteger(0);

        pyramid.getBoard().eachCell((cell) -> {
            assertEquals(0, cell.getPieceNumber());
            count.incrementAndGet();
        });

        assertEquals(55, count.get());
    }

    @Test
    public void put_a_piece_on_board() {
        boolean result = pyramid.put(Piece.A1, 0, 0);
        Board board = pyramid.getBoard();

        assertTrue(result);
        assertEquals(Piece.TYPE_A, board.getCell(2, 0).getPieceNumber());
        assertEquals(Piece.TYPE_A, board.getCell(0, 1).getPieceNumber());
        assertEquals(Piece.TYPE_A, board.getCell(1, 1).getPieceNumber());
        assertEquals(Piece.TYPE_A, board.getCell(2, 1).getPieceNumber());
    }

    @Test
    public void put_a_piece_out_of_board() {
        boolean result = pyramid.put(Piece.A1, 0, 9);

        assertFalse(result);
    }

    @Test
    public void put_two_pieces_overlap_on_board() {
        assertTrue(pyramid.put(Piece.A1, 0, 0));
        assertFalse(pyramid.put(Piece.A1, 0, 1));
    }
}

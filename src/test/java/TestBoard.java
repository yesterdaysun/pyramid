import junit.framework.TestCase;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by Eric on 16/7/1.
 */
public class TestBoard {
    @Test
    public void build_state_list_empty_board() {
        Board board = new Board();

        List<Boolean> result = board.buildStateList(false);

        assertEquals(13 + 55, result.size());
        result.forEach(TestCase::assertFalse);
    }

    @Test
    public void build_state_list_one_piece(){
        Board board = new Board();

        board.put(Piece.A1,0,0);
        List<Boolean> result = board.buildStateList(true);

        assertTrue(result.get(0));
        assertTrue(result.get(Piece.TYPE_A));
        assertTrue(result.get(15));
        assertTrue(result.get(23));
        assertTrue(result.get(24));
        assertTrue(result.get(25));
    }

    @Test
    public void build_state_list_two_piece(){
        Board board = new Board();

        board.put(Piece.A1,0,0);
        board.put(Piece.F1,8,0);
        List<Boolean> result = board.buildStateList(true);

        assertTrue(result.get(0));
        assertTrue(result.get(Piece.TYPE_A));
        assertTrue(result.get(15));
        assertTrue(result.get(23));
        assertTrue(result.get(24));
        assertTrue(result.get(25));

        assertTrue(result.get(Piece.TYPE_F));
        assertTrue(result.get(21));
        assertTrue(result.get(22));
        assertTrue(result.get(31));
    }
}
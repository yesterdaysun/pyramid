import junit.framework.TestCase;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

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
}
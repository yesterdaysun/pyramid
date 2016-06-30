import org.junit.Test;

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
}

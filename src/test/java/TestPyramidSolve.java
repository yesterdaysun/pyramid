import org.junit.Test;

import java.util.ArrayList;
import java.util.Set;

import static org.junit.Assert.assertEquals;

/**
 * Created by Eric on 16/7/1.
 */
public class TestPyramidSolve {
    @Test
    public void one_piece() {
        Pyramid pyramid = new Pyramid();
        pyramid.put(Piece.A4, 6, 0);
        pyramid.put(Piece.B1, 2, 0);
        pyramid.put(Piece.C6, 0, 5);
        pyramid.put(Piece.D4, 2, 4);
        pyramid.put(Piece.E8, 5, 0);
//        pyramid.put(Piece.F1, 8, 0);
        pyramid.put(Piece.G2, 0, 2);
        pyramid.put(Piece.H2, 3, 3);
        pyramid.put(Piece.I4, 1, 3);
        pyramid.put(Piece.J2, 0, 6);
        pyramid.put(Piece.K, 0, 0);
        pyramid.put(Piece.L, 3, 1);

        Set<Step> solve = pyramid.solve();

        ArrayList<Step> steps = new ArrayList<>();
        steps.addAll(solve);

        assertEquals(1, steps.size());
        assertStep(Piece.F1, 8, 0, steps.get(0));
    }

    private void assertStep(Piece piece, int col, int row, Step step) {
        assertEquals(piece, step.getPiece());
        assertEquals(col, step.getCol());
        assertEquals(row, step.getRow());
    }
}

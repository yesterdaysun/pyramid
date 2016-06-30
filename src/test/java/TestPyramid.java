import org.junit.Test;

import java.util.concurrent.atomic.AtomicInteger;

import static org.junit.Assert.assertEquals;

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
}

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by Eric on 16/6/30.
 */
public class TestDancingLink {
    @Test
    public void empty_input() {
        List<List<Boolean>> input = new ArrayList<>();
        DancingLink dancingLink = new DancingLink(input);

        List<Integer> solution = dancingLink.getAnswer();

        assertTrue(solution.isEmpty());
    }

    @Test
    public void one_item_input() {
        List<List<Boolean>> input = Arrays.asList(Arrays.asList(true));

        DancingLink dancingLink = new DancingLink(input);
        List<Integer> solution = dancingLink.getAnswer();

        assertArrayEquals(new Integer[]{0}, solution.toArray());
    }
}

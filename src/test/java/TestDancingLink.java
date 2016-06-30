import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertTrue;

/**
 * Created by Eric on 16/6/30.
 */
public class TestDancingLink {
    @Test
    public void empty_input() {
        List<List<Boolean>> input = new ArrayList<>();
        DancingLink dancingLink = new DancingLink(input);

        List<Integer> solution = dancingLink.solve();

        assertTrue(solution.isEmpty());
    }
}

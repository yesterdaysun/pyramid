import org.junit.Test;

import java.util.*;

import static org.junit.Assert.*;

/**
 * Created by Eric on 16/6/30.
 */
public class TestDancingLink {
    @Test
    public void empty_input() {
        List<List<Boolean>> input = new ArrayList<>();
        DancingLink dancingLink = new DancingLink(input);

        Set<Integer> solution = dancingLink.getAnswers();

        assertTrue(solution.isEmpty());
    }

    @Test
    public void one_item_input() {
        List<List<Boolean>> input = Arrays.asList(Arrays.asList(true));

        DancingLink dancingLink = new DancingLink(input);
        Set<Integer> solution = dancingLink.getAnswers();

        assertArrayEquals(new Integer[]{0}, solution.toArray());
    }

    @Test
    public void two_items_overlap() {
        List<List<Boolean>> input = Arrays.asList(
                Arrays.asList(true),
                Arrays.asList(true)
        );

        DancingLink dancingLink = new DancingLink(input);
        Set<Integer> solution = dancingLink.getAnswers();

        assertEquals(expectedAnswer(0), solution);
    }

    @Test
    public void two_item_success() {
        List<List<Boolean>> input = Arrays.asList(
                Arrays.asList(false, true),
                Arrays.asList(true, false)
        );

        DancingLink dancingLink = new DancingLink(input);
        Set<Integer> solution = dancingLink.getAnswers();

        assertEquals(expectedAnswer(0, 1), solution);
    }

    @Test
    public void complex_7x6() {
        List<List<Boolean>> input = Arrays.asList(
                Arrays.asList(false, false, true, false, true, true, false),
                Arrays.asList(true, false, false, true, false, false, true),
                Arrays.asList(false, true, true, false, false, true, false),
                Arrays.asList(true, false, false, true, false, false, false),
                Arrays.asList(false, true, false, false, false, false, true),
                Arrays.asList(false, false, false, true, true, false, true)
        );

        DancingLink dancingLink = new DancingLink(input);
        Set<Integer> solution = dancingLink.getAnswers();
        assertEquals(expectedAnswer(0, 3, 4), solution);
    }

    private Set<Integer> expectedAnswer(int... answers) {
        HashSet<Integer> result = new HashSet<>();
        for (int answer : answers) {
            result.add(answer);
        }
        return result;
    }
}

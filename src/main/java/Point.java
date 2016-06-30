import lombok.Data;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Eric on 16/6/30.
 */
@Data
public class Point {
    private static Map<Integer, List<Integer>> RotateMatrix = new HashMap<Integer, List<Integer>>() {{
        put(90, Arrays.asList(0, -1, 1, 0));
        put(180, Arrays.asList(-1, 0, 0, -1));
        put(270, Arrays.asList(0, 1, -1, 0));
    }};

    private final int x;
    private final int y;

    public Point rotate(int degree) {
        List<Integer> matrix = RotateMatrix.get(degree);
        Integer newX = x * matrix.get(0) + y * matrix.get(1);
        Integer newY = x * matrix.get(2) + y * matrix.get(3);
        return new Point(newX, newY);
    }

    public Point move(Point offset) {
        return new Point(x + offset.getX(), y + offset.getY());
    }
}

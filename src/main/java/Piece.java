import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

/**
 * Created by Eric on 16/6/30.
 */
/*
1
A:     A
   A A A

2
B: B B B
   B B

3
C: C
   C C C C

4
D: D D D D
     D

5
E: E E E
       E E

6
F: F F
   F

7
G: G
   G
   G G G

8
H: H H
     H H
       H

9
I: I I
     I
   I I

10
J: J J J J

11
K: K K
   K K

12
L:   L
   L L L
     L

 */
public class Piece {
    public static final int TYPE_A = 1;

    public static Piece A1;

    static {
        A1 = new Piece(TYPE_A, new Point(2, 0), new Point(0, 1), new Point(1, 1), new Point(2, 1));
    }

    private int pieceNumber;
    private List<Point> points;

    public Piece(int pieceNumber, Point... points) {
        this.pieceNumber = pieceNumber;
        this.points = Arrays.asList(points);
    }

    public int getPieceNumber() {
        return pieceNumber;
    }

    public void eachPoint(Consumer<Point> consumer) {
        points.forEach(consumer);
    }
}

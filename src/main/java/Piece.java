import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;

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
    public static final int TYPE_B = 2;
    public static final int TYPE_C = 3;
    public static final int TYPE_D = 4;
    public static final int TYPE_E = 5;
    public static final int TYPE_F = 6;
    public static final int TYPE_G = 7;
    public static final int TYPE_H = 8;
    public static final int TYPE_I = 9;
    public static final int TYPE_J = 10;
    public static final int TYPE_K = 11;
    public static final int TYPE_L = 12;

    public static Piece A1;
    public static Piece A2;
    public static Piece A3;
    public static Piece A4;

    static {
        A1 = new Piece(TYPE_A, new Point(2, 0), new Point(0, 1), new Point(1, 1), new Point(2, 1));
        A2 = A1.rotate(90);
        A3 = A2.rotate(90);
        A4 = A3.rotate(90);
    }

    private int pieceNumber;
    private List<Point> points;

    public Piece(int pieceNumber, Point... points) {
        this.pieceNumber = pieceNumber;
        this.points = Arrays.asList(points);
    }

    public Piece(int pieceNumber, List<Point> newPoints) {
        this.pieceNumber = pieceNumber;
        this.points = newPoints;
    }

    public int getPieceNumber() {
        return pieceNumber;
    }

    public void eachPoint(Consumer<Point> consumer) {
        points.forEach(consumer);
    }

    public Piece rotate(int degree) {
        List<Point> newPoints = points.stream().map((point) -> point.rotate(degree)).collect(Collectors.toList());
        Point leftTop = findLeftTopPoint(newPoints);
        Point offset = new Point(0 - leftTop.getX(), 0 - leftTop.getY());
        newPoints = newPoints.stream().map((point) -> point.move(offset)).collect(Collectors.toList());

        return new Piece(getPieceNumber(), newPoints);
    }

    private Point findLeftTopPoint(List<Point> points) {
        return new Point(
                points.stream().mapToInt(Point::getX).min().getAsInt(),
                points.stream().mapToInt(Point::getY).min().getAsInt());
    }
}

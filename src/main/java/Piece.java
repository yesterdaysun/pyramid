import java.util.*;
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
    public static final int TYPE_EMPTY = 0;
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
    public static Piece A5;
    public static Piece A6;
    public static Piece A7;
    public static Piece A8;

    public static Piece B1;
    public static Piece B2;
    public static Piece B3;
    public static Piece B4;
    public static Piece B5;
    public static Piece B6;
    public static Piece B7;
    public static Piece B8;

    public static Piece C1;
    public static Piece C2;
    public static Piece C3;
    public static Piece C4;
    public static Piece C5;
    public static Piece C6;
    public static Piece C7;
    public static Piece C8;

    public static Piece D1;
    public static Piece D2;
    public static Piece D3;
    public static Piece D4;
    public static Piece D5;
    public static Piece D6;
    public static Piece D7;
    public static Piece D8;

    public static Piece E1;
    public static Piece E2;
    public static Piece E3;
    public static Piece E4;
    public static Piece E5;
    public static Piece E6;
    public static Piece E7;
    public static Piece E8;

    public static Piece F1;
    public static Piece F2;
    public static Piece F3;
    public static Piece F4;

    public static Piece G1;
    public static Piece G2;
    public static Piece G3;
    public static Piece G4;

    public static Piece H1;
    public static Piece H2;
    public static Piece H3;
    public static Piece H4;

    public static Piece I1;
    public static Piece I2;
    public static Piece I3;
    public static Piece I4;

    public static Piece J1;
    public static Piece J2;

    public static Piece K;

    public static Piece L;

    public static Map<Integer, List<Piece>> PieceMap;

    static {
        //     A
        // A A A
        A1 = new Piece(TYPE_A, new Point(2, 0), new Point(0, 1), new Point(1, 1), new Point(2, 1));
        // A
        // A
        // A A
        A2 = A1.rotate(90);
        // A A A
        // A
        A3 = A2.rotate(90);
        // A A
        //   A
        //   A
        A4 = A3.rotate(90);
        // A A A
        //     A
        A5 = A1.flip();
        //   A
        //   A
        // A A
        A6 = A5.rotate(90);
        // A
        // A A A
        A7 = A6.rotate(90);
        // A A
        // A
        // A
        A8 = A7.rotate(90);

        // B B B
        // B B
        B1 = new Piece(TYPE_B, new Point(0, 0), new Point(1, 0), new Point(2, 0), new Point(0, 1), new Point(1, 1));
        // B B
        // B B
        //   B
        B2 = B1.rotate(90);
        //   B B
        // B B B
        B3 = B2.rotate(90);
        // B
        // B B
        // B B
        B4 = B3.rotate(90);
        // B B
        // B B B
        B5 = B1.flip();
        // B B
        // B B
        // B
        B6 = B5.rotate(90);
        // B B B
        //   B B
        B7 = B6.rotate(90);
        //   B
        // B B
        // B B
        B8 = B7.rotate(90);

        // C
        // C C C C
        C1 = new Piece(TYPE_C, new Point(0, 0), new Point(0, 1), new Point(1, 1), new Point(2, 1), new Point(3, 1));
        // C C
        // C
        // C
        // C
        C2 = C1.rotate(90);
        // C C C C
        //       C
        C3 = C2.rotate(90);
        //   C
        //   C
        //   C
        // C C
        C4 = C3.rotate(90);
        // C C C C
        // C
        C5 = C1.flip();
        // C C
        //   C
        //   C
        //   C
        C6 = C5.rotate(90);
        //       C
        // C C C C
        C7 = C6.rotate(90);
        // C
        // C
        // C
        // C C
        C8 = C7.rotate(90);

        // D D D D
        //   D
        D1 = new Piece(TYPE_D, new Point(0, 0), new Point(1, 0), new Point(2, 0), new Point(3, 0), new Point(1, 1));
        //   D
        // D D
        //   D
        //   D
        D2 = D1.rotate(90);
        //     D
        // D D D D
        D3 = D2.rotate(90);
        // D
        // D
        // D D
        // D
        D4 = D3.rotate(90);
        //   D
        // D D D D
        D5 = D1.flip();
        // D
        // D D
        // D
        // D
        D6 = D5.rotate(90);
        // D D D D
        //     D
        D7 = D6.rotate(90);
        //   D
        //   D
        // D D
        //   D
        D8 = D7.rotate(90);

        // E E E
        //     E E
        E1 = new Piece(TYPE_E, new Point(0, 0), new Point(1, 0), new Point(2, 0), new Point(2, 1), new Point(3, 1));
        //   E
        //   E
        // E E
        // E
        E2 = E1.rotate(90);
        // E E
        //   E E E
        E3 = E2.rotate(90);
        //   E
        // E E
        // E
        // E
        E4 = E3.rotate(90);
        //     E E
        // E E E
        E5 = E1.flip();
        // E
        // E
        // E E
        //   E
        E6 = E5.rotate(90);
        //   E E E
        // E E
        E7 = E6.rotate(90);
        // E
        // E E
        //   E
        //   E
        E8 = E7.rotate(90);

        // F F
        // F
        F1 = new Piece(TYPE_F, new Point(0, 0), new Point(0, 1), new Point(1, 0));
        // F F
        //   F
        F2 = F1.rotate(90);
        //   F
        // F F
        F3 = F2.rotate(90);
        // F
        // F F
        F4 = F3.rotate(90);

        // G
        // G
        // G G G
        G1 = new Piece(TYPE_G, new Point(0, 0), new Point(0, 1), new Point(0, 2), new Point(1, 2), new Point(2, 2));
        // G G G
        // G
        // G
        G2 = G1.rotate(90);
        // G G G
        //     G
        //     G
        G3 = G2.rotate(90);
        //     G
        //     G
        // G G G
        G4 = G3.rotate(90);

        // H H
        //   H H
        //     H
        H1 = new Piece(TYPE_H, new Point(0, 0), new Point(1, 0), new Point(1, 1), new Point(2, 1), new Point(2, 2));
        //     H
        //   H H
        // H H
        H2 = H1.rotate(90);
        // H
        // H H
        //   H H
        H3 = H2.rotate(90);
        //   H H
        // H H
        // H
        H4 = H3.rotate(90);

        // I I
        //   I
        // I I
        I1 = new Piece(TYPE_I, new Point(0, 0), new Point(1, 0), new Point(1, 1), new Point(1, 2), new Point(0, 2));
        // I   I
        // I I I
        I2 = I1.rotate(90);
        // I I
        // I
        // I I
        I3 = I2.rotate(90);
        // I I I
        // I   I
        I4 = I3.rotate(90);

        // J J J J
        J1 = new Piece(TYPE_J, new Point(0, 0), new Point(1, 0), new Point(2, 0), new Point(3, 0));
        // J
        // J
        // J
        // J
        J2 = J1.rotate(90);

        // K K
        // K K
        K = new Piece(TYPE_K, new Point(0, 0), new Point(1, 0), new Point(0, 1), new Point(1, 1));

        //   L
        // L L L
        //   L
        L = new Piece(TYPE_L, new Point(1, 0), new Point(0, 1), new Point(1, 1), new Point(2, 1), new Point(1, 2));

        PieceMap = new HashMap<Integer, List<Piece>>() {{
            put(0, Collections.emptyList());
            put(1, Arrays.asList(A1, A2, A3, A4, A5, A6, A7, A8));
            put(2, Arrays.asList(B1, B2, B3, B4, B5, B6, B7, B8));
            put(3, Arrays.asList(C1, C2, C3, C4, C5, C6, C7, C8));
            put(4, Arrays.asList(D1, D2, D3, D4, D5, D6, D7, D8));
            put(5, Arrays.asList(E1, E2, E3, E4, E5, E6, E7, E8));
            put(6, Arrays.asList(F1, F2, F3, F4));
            put(7, Arrays.asList(G1, G2, G3, G4));
            put(8, Arrays.asList(H1, H2, H3, H4));
            put(9, Arrays.asList(I1, I2, I3, I4));
            put(10, Arrays.asList(J1, J2));
            put(11, Arrays.asList(K));
            put(12, Arrays.asList(L));
        }};
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

    public List<Point> getPoints() {
        return points;
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

    public Piece flip() {
        List<Point> newPoints = points.stream().map(Point::flip).collect(Collectors.toList());
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

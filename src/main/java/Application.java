/**
 * Created by Eric on 16/6/30.
 */
public class Application {
    public static void main(String[] args) {
        Pyramid pyramid = new Pyramid();
        pyramid.put(Piece.A4, 6, 0);
        pyramid.put(Piece.B1, 2, 0);
        pyramid.put(Piece.C6, 0, 5);
        pyramid.put(Piece.D4, 2, 4);
        pyramid.put(Piece.E8, 5, 0);
        pyramid.put(Piece.F1, 8, 0);
        pyramid.put(Piece.G2, 0, 2);
        pyramid.put(Piece.H2, 3, 3);
        pyramid.put(Piece.I4, 1, 3);
        pyramid.put(Piece.J2, 0, 6);
        pyramid.put(Piece.K, 0, 0);
        pyramid.put(Piece.L, 3, 1);
        pyramid.print();
    }
}

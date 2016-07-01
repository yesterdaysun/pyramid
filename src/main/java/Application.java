import org.apache.commons.lang3.time.StopWatch;

import java.util.Set;

/**
 * Created by Eric on 16/6/30.
 */
public class Application {
    public static void main(String[] args) {
        // puzzle 355
        Pyramid pyramid = new Pyramid();
        pyramid.put(Piece.B6, 0, 0);
        pyramid.put(Piece.H4, 0, 2);
//        pyramid.put(Piece.I4, 2, 0);
//        pyramid.put(Piece.E2, 2, 1);
//        pyramid.put(Piece.L, 2, 4);
//        pyramid.put(Piece.A2, 1, 4);
//        pyramid.put(Piece.G1, 0, 5);
//        pyramid.put(Piece.F1, 0, 8);
//        pyramid.put(Piece.K, 4, 3);
//        pyramid.put(Piece.D7, 4, 2);

        pyramid.print();
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        Set<Step> solve = pyramid.solve();
        stopWatch.stop();
        solve.forEach(pyramid::put);
        pyramid.print();

        System.out.println(String.format("\nUsed: %.2f s", stopWatch.getTime() / 1000.0));
    }

    private static void printSample() {
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

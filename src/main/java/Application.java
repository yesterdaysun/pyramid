import java.io.IOException;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by Eric on 16/6/30.
 */
public class Application {
    public static void main(String[] args) throws IOException {
        clearConsole();

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

        moveCursorToLetTop();
        pyramid.print();

//        Date startTime = new Date();

        AtomicInteger count = new AtomicInteger(0);
        pyramid.solve(answers -> {
            count.incrementAndGet();
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Board board = new Board();
            board.put(Piece.B6, 0, 0);
            board.put(Piece.H4, 0, 2);
            answers.forEach(step -> {
                board.put(step.getPiece(), step.getCol(), step.getRow());
            });
            moveCursorToLetTop();
            board.print();
        });

        System.out.println();
        System.out.println(String.format("Tries: %d times.", count.get()));

//        Date endTime = new Date();

//        moveCursorToLetTop();
//        pyramid.print();

//        System.out.println(String.format("\nUsed: %.2f s", (endTime.getTime() - startTime.getTime()) / 1000.0));
    }

    private static void moveCursorToLetTop() {
        System.out.print(String.format("%c[%d;%df", 0x1B, 0, 0));
    }

    private static void clearConsole() {
        moveCursorToLetTop();
        for (int i = 0; i < 15; i++) {
            System.out.println("                                                                                ");
        }
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

import java.util.Scanner;

/**
 * Created by Eric on 16/6/30.
 */
public class Application {
    public static void main(String[] args) {
        Pyramid pyramid = new Pyramid();
        pyramid.put(Piece.A3,0,0);
        pyramid.put(Piece.A5,0,5);
        pyramid.print();
    }
}

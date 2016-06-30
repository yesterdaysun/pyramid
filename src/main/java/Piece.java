import lombok.Data;

/**
 * Created by Eric on 16/6/30.
 */
public class Piece {
    private int pieceNumber;

    public Piece(int pieceNumber) {
        this.pieceNumber = pieceNumber;
    }

    public int getPieceNumber() {
        return pieceNumber;
    }
}

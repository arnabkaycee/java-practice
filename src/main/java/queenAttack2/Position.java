package queenAttack2;

public class Position {
    private int x;
    private int y;

    public Position(Position p) {
        this.x = p.x;
        this.y = p.y;
    }

    public Position(){};

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}

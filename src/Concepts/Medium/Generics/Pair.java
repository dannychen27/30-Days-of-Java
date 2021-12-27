package Concepts.Medium.Generics;

public class Pair<T, U> {
    private T x;
    private U y;

    T getX() {
        return x;
    }

    U getY() {
        return y;
    }

    void setX(T x) {
        this.x = x;
    }

    void setY(U y) {
        this.y = y;
    }
}

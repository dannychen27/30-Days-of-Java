package Concepts.Hard.Generics;

public class Item <T> {
    private T x;

    T getX() {
        return x;
    }

    void setX(T x) {
        this.x = x;
    }
}

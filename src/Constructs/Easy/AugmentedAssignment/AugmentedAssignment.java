package Constructs.Easy.AugmentedAssignment;

public class AugmentedAssignment {

    public static void main(String[] args) {
        int x = 15;
        x += 4; // x is 19
        x /= 4; // x is 4
        x *= 4; // x is 16
        x -= 4; // x is 12
        x %= 5; // x is 2
        System.out.println(x); // 2

        int y = 5;
        y &= 4; // y is 4
        y |= 5; // y is 5
        y ^= 4; // y is 1
        System.out.println(y); // 1

        int a = 4;
        a <<= 1; // a is 8
        System.out.println(a); // 8

        int b = 2;
        b >>= 1; // b is 1
        System.out.println(b); // 1
    }
}

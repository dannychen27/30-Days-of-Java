package JavaConstructs.Easy.TernaryIfStatements;

public class TernaryIfStatements {

    public static void main(String[] args) {
        // A ternary if-statement lets you write an if-statement in 1 line.
        // It is of the form:
        //          condition ? result1 : result2

        // Without ternary if (simple if-else)
        int a = 5;
        int b;
        if (a < 0) {
            b = 4;
        } else {
            b = 6;
        }
        System.out.println(b);

        // With ternary if (simple)
        int c = 5;
        int d = c < 0 ? 4 : 6;
        System.out.println(d);

        // Without ternary if (if-elseif-else)
        int e = 3;
        int f;
        if (e < 0) {
            f = 2;
        } else if (e > 0) {
            f = 4;
        } else {
            f = 3;
        }
        System.out.println(f);

        // With ternary if (complex)
        int g = 3;
        int h = g < 0 ? 2 : (g > 0 ? 4 : 3);
        System.out.println(h);
    }
}

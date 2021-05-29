package JavaConcepts.Easy.DeclarationAndInitialization;

public class DeclarationAndInitialization {

    public static void main(String[] args) {
        // - declaration: declaring a variable's type
        // - initialization: setting a variable's value for the first time

        // When declaration can come before initialization
        int x;  // declaration
        x = 5;  // initialization
        System.out.println("The value of x is " + x);

        int y = 10;  // declaration and initialization
        System.out.println("The value of y is " + y);

        // When declaration must come before initialization
        int z;
        if (x == 5) {
            z = 1;
        } else if (y == 10) {
            z = 2;
        } else {
            z = 3;
        }
        System.out.println("The value of z is " + z);
    }
}

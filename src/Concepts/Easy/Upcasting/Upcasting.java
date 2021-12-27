package Concepts.Easy.Upcasting;

public class Upcasting {

    public static void main(String[] args) {
        // upcasting (widening casting)
        //      -- converting a smaller type to a larger type size
        //      i.e. byte -> short -> char -> int -> long -> float -> double
        //      -- done automatically
        //      -- large primitive type value accommodates smaller primitive type value;
        //      -- superclass accommodates subclass
        //      -- like pouring the contents of a smaller cup into a larger cup, no risk of overflow
        int intScore = 9;
        double doubleScore = intScore;  // no casting required -- just add padding zeroes
        System.out.println(intScore);
        System.out.println(doubleScore);
    }
}

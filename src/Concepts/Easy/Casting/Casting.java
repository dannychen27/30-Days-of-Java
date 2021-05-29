package Concepts.Easy.Casting;

public class Casting {

    public static void main(String[] args) {
        // upcasting (widening casting)
        //      -- converting a smaller type to a larger type size
        //      i.e. byte -> short -> char -> int -> long -> float -> double
        //      -- done automatically
        int intScore = 9;
        double doubleScore = intScore;  // no casting required -- just add padding zeroes
        System.out.println(intScore);
        System.out.println(doubleScore);

        // downcasting (narrowing casting)
        //      -- converting a larger type to a smaller type size
        //      i.e. double -> float -> long -> int -> char -> short -> byte
        //      -- done manually
        double doubleReward = 9.0;
        int intReward = (int) doubleReward; // casting required since you are truncating!
        System.out.println(doubleReward);
        System.out.println(intReward);
    }
}

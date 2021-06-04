package Concepts.Easy.DownCasting;

public class Downcasting {

    public static void main(String[] args) {
        // source: https://www.decodejava.com/widening-and-narrowing-in-java.htm#:~:text=Widening%20takes%20place%20when%20a,reference%20variable%20of%20its%20superclass
        // downcasting (narrowing casting)
        //      -- converting a larger type to a smaller type size
        //      i.e. double -> float -> long -> int -> char -> short -> byte
        //      -- done manually
        //      -- shrinking a large primitive type value into a smaller primitive type value
        //      -- shrink superclass into subclass
        //      -- like pouring the contents of a larger cup into a smaller cup, it might overflow
        double doubleReward = 9.0;
        int intReward = (int) doubleReward; // casting required since you are truncating!
        System.out.println(doubleReward);
        System.out.println(intReward);
    }
}

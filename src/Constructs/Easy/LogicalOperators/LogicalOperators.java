package Constructs.Easy.LogicalOperators;

public class LogicalOperators {

    public static void main(String[] args) {
        // logical operators in Java return a boolean value:
        // - &&, logical and
        // - ||, logical (inclusive) or
        // - !, logical not

        String message1 = "Diffusers";
        String message2 = "Diffusers";
        String message3 = "Strawberries";

        boolean statement1 = message1.equals(message2); // true
        boolean statement2 = message2.equals(message1); // true
        boolean statement3 = message2.equals(message3); // false
        boolean statement4 = message3.equals(message2); // false

        System.out.println(statement1 || statement3); // true
        System.out.println(statement1 && statement2); // true
        System.out.println(!statement4); // true
    }
}

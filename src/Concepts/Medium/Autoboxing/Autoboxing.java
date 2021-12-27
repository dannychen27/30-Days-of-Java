package Concepts.Medium.Autoboxing;

import java.util.ArrayList;
import java.util.List;

public class Autoboxing {

    public static void main(String[] args) {
        // Sources:
        // https://docs.oracle.com/javase/tutorial/java/data/autoboxing.html#:~:text=Autoboxing%20is%20the%20automatic%20conversion,way%2C%20this%20is%20called%20unboxing.
        // https://www.geeksforgeeks.org/autoboxing-unboxing-java/
        // https://www.javatpoint.com/autoboxing-and-unboxing

        // - Autoboxing is when the Java compiler automatically converts primitive types
        // into their corresponding object wrapper classes.
        // - Unboxing is when the Java compiler automatically converts object wrapper
        // classes back into their corresponding primitive types.

        // The Java compiler applies autoboxing when a primitive value is:
        // 1. Passed as a parameter to a method that expects an object of the corresponding wrapper class.
        // 2. Assigned to a variable of the corresponding wrapper class.

        // The Java compiler applies unboxing when an object of a wrapper class is:
        // 1. Passed as a parameter to a method that expects a value of the corresponding primitive type.
        // 2. Assigned to a variable of the corresponding primitive type.

        // - Sometimes certain objects require Object and its subclasses in the type declaration
        // for the purposes of object initialization
        // e.g. Hashmap<Integer, Character> h = new HashMap<>(); is OK
        // whereas Hashmap<int, char> is not acceptable
        // - The benefit of autoboxing and unboxing is that it lets Java developers write
        // cleaner code by letting us use primitive types and wrapper class objects
        // interchangeably without having to perform explicit type casting.

        // - Here are the primitive types and wrapper classes Java uses for autoboxing and unboxing.
        //      Primitive type	     Wrapper class (reference type)
        //          boolean	            Boolean
        //          byte	            Byte
        //          char	            Character
        //          float	            Float
        //          int	                Integer
        //          long	            Long
        //          short	            Short
        //          double	            Double
        demonstrateBoxingThroughAssignment();
        List<Integer> listOfOddIntegers = demonstrateBoxingThroughPassingInMethodParameters();
        demonstrateUnboxingThroughAssignment(listOfOddIntegers);
        demonstrateUnboxingThroughComparisonOperators(listOfOddIntegers);
    }

    private static void demonstrateBoxingThroughAssignment() {
        // The Java compiler treats Integer and int as the same thing.
        Integer i = 3; // boxing i so it's an Integer
        int j = 3; // unboxing i so it's an int
        System.out.println(i == j); // true
    }

    private static List<Integer> demonstrateBoxingThroughPassingInMethodParameters() {
        // Consider the .add() and System.out.println() method that requires an Integer as a parameter.
        List<Integer> listOfOddIntegers = new ArrayList<>(); // a list of Integer objects, not a list of int values.
        for (int k = 1; k < 10; k += 2) {
            listOfOddIntegers.add(k);
            System.out.println(k); // 1, 3, 5, 7, 9
        }

        // The Java compiler compiles the above code as:
        //
        // List<Integer> listOfOddIntegers = new ArrayList<>();
        // for (int k = 1; k < 10; k += 2) {
        //     listOfOddIntegers.add(Integer.valueOf(k));
        //     System.out.println(Integer.valueOf(k)); // 1, 3, 5, 7, 9
        // }

        // Because the Java compiler converted the int into Integer, (perhaps Integer.value(k))
        // the Java compiler does not issue a compile time error.
        return listOfOddIntegers;
    }

    private static void demonstrateUnboxingThroughAssignment(List<Integer> listOfOddIntegers) {
        int firstInt = listOfOddIntegers.get(0); // like listOfOddIntegers.get(0).intValue()
        System.out.println("First Item in List = " + firstInt); // First Item in List: 1
    }

    private static void demonstrateUnboxingThroughComparisonOperators(List<Integer> listOfOddIntegers) {
        // Now consider the following method:
        int sum = 0;
        for (Integer l : listOfOddIntegers) {
            if (l % 2 != 0) {  // unbox l
                sum += l; // unbox l
            }
        }
        System.out.println(sum); // 25

        // the + and % operators do not apply to Integer objects, so java unboxes the Integer
        // object into an int using the intValue() method so that it can perform the + and %
        // operators on the int type without error.
        //
        // int sum = 0;
        // for (Integer l : listOfOddIntegers) {
        //     if (l.intValue() % 2 == 0) {
        //         sum += l.intValue(); // Integer -> int
        //     }
        //     System.out.println(Integer.valueOf(l));
        // }
    }
}

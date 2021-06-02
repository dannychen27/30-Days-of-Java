package Constructs.Easy.PrimitiveAndReferenceTypes;

public class PrimitiveAndReferenceTypes {

    public static void main(String[] args) {
        // Source: https://www.javatpoint.com/java-data-types

        // - A primitive type is a built in Java type.
        // - A non-primitive (object) type could be a user-created Class, String, Interface, and Array.
        // - A primitive type can be made non-primitive using autoboxing (writing its full object name)
        //      e.g. int -> Integer, char -> Character

        // - Java has 8 primitive types:
        //      PRIMITIVE TYPE          DEFAULT VALUE            RANGE (inclusive)                                      SPACE REQUIREMENT
        //      -   boolean                 false                 true, false,                                          1 bit
        //      -     char                 '\u0000'           '\u0000' to '\uffff'                                      2 bytes = 16 bits
        //                                                    (0 to 2^16 - 1 = 65535)
        //      -     byte                     0                  -128 to 127                                           1 byte = 8 bits
        //                                                      (-2^7 to 2^7 - 1)
        //      -    short                     0                -32,768 to 32,767                                       2 bytes = 16 bits
        //                                                      (-2^15 to 2^15 - 1)
        //      -     int                      0             -2,147,483,648 to 2,147,483,647                            4 bytes = 32 bits
        //                                                      (-2^31 to 2^31 - 1)
        //      -    float                     0.0f                  unlimited                                          4 bytes = 32 bits
        //      -     long                     0L          -9,223,372,036,854,775,808 to 9,223,372,036,854,775,807      8 bytes = 32 bits
        //                                                      (-2^63 to 2^63 - 1)
        //      -    double                    0.0d                  unlimited                                          8 bytes = 32 bits
        demonstrateIntegerLimits();
        demonstrateDoubleLimits();
        questions();
    }

    private static void demonstrateIntegerLimits() {
        System.out.println(Integer.MIN_VALUE); // -2147483648
        System.out.println(Integer.MAX_VALUE); // 2147483647
        System.out.println(Integer.SIZE); // 32
        System.out.println(Integer.TYPE); // int
    }

    private static void demonstrateDoubleLimits() {
        System.out.println(Double.POSITIVE_INFINITY); // Infinity
        System.out.println(Double.NEGATIVE_INFINITY); // -Infinity
        System.out.println(Double.NaN); // NaN
        System.out.println(Double.isFinite(5)); // true
        System.out.println(Double.isInfinite(Double.NEGATIVE_INFINITY)); // true
        System.out.println(Double.isNaN(Double.NaN)); // true
    }

    private static void questions() {
        // Q1: Why does char use 2 bytes in java?
        // A1: char uses 2 bytes in java because it uses the unicode system, not ascii

        // Q2: What is the char '\u0000'?
        // A2: The '\u0000' is the lowest value in the unicode system.

        // Q3: What does the f, d, and L at the end of 0.0f, 0.0d, 0.0L mean?
        // How is it similar to casting numbers explicitly as (float), (double), or (long)?
        // A3: The f, d, and L are shorthand for typecasting as (float), (double), or (long).

        // Q4: What's the difference between floats and doubles? Integers and longs?
        // A4: floats should never be used to store precise values like currency (this leads to rounding error)
        // they're for saving memory.
        // similar argument for ints vs. longs

        // Q5: Why are the exponents off by 1?
        // A5: To account for the signed bit.

        // Q6: What system does Java use for storing floating point numbers?
        // A6: Java uses IEEE 754 floating point (I think it's industry standard?) to storing
        // floating point numbers.
    }
}

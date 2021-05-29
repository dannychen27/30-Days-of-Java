package Concepts.Medium.Exceptions;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class ExceptionBasics {

    public static void main(String[] args) {
        // compile time error = code is syntactically incorrect (ill-formed)
        // runtime error = code is semantically incorrect (well-formed but nonsensical)
        // exception = runtime error
        // - exceptions are meant to handle code that deviates from normal program flow
        // (e.g. abnormal program termination)
        // - use logic over exceptions
        // - do not use exceptions like normal control flow statements e.g. if-then-else
        // they are not designed that way. exceptions should happen RARELY.
        // - exceptions let us do whatever we want with code that would otherwise crash a program
        // e.g. reconnect to database in 10 seconds, re-prompt the user for a file,
        // print an custom informative error message, etc.
        uncheckedExceptions();
        checkedExceptions();
    }

    private static void uncheckedExceptions() {
        // unchecked exception -- not checked by the compiler, user is expected to know how to handle it
        // - it's a programming error
        // - try/catch or adding "throws SomeException" at the end of the function signature is optional
        int number = Integer.parseInt("pizza");  // NumberFormatException

        ArrayList<Integer> x = new ArrayList<>();
        x.get(5);  // IndexOutOfBoundsException
    }

    private static void checkedExceptions() {
        // checked exception -- checked by the compiler, user is not expected to know how to handle it
        // it's a user error, it's out of your control
        // You must either...
        // - add "throws SomeException" at the end of the function the signature OR
        // - surround the exception-producing code in a try-catch block.
        try {
            FileInputStream f = new FileInputStream("");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}

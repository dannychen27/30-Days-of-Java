package JavaConcepts.Medium.BasicOOP.Exceptions;

import java.io.IOException;

public class CustomException {

    public static void main(String[] args) {
        CustomException exceptions = new CustomException();
        exceptions.doSomething();
    }

    private void doSomething() {
        // - catch a specific exception rather than a generic one
        // - exception e = catch all exception
        // - Java reads catch blocks from top to bottom, so arrange catch blocks
        // from specific to general, or else the compiler will complain that one
        // of the exceptions is unreachable
        // - if you want to want to handle multiple exceptions the same way, you can
        // combine them using the pipe (|) operator:
        //     - IOException | IndexOutOfBoundsException e
        // - prefer try-catch over "throws SomeException" -- otherwise you will have long
        // try blocks!
        // - ideally catch blocks are relatively short
        try {
            // throw new CustomException();
            // System.out.println("Hello");
            throw new IOException();
        }
        catch (IOException | IndexOutOfBoundsException e) {
            System.out.println("I'm a more specific exception");
        }
        catch (Exception e) {  // a generic exception
            System.out.println("I'm a general exception");
        } finally { // This part always runs, exception or not
            // resource cleanup
            System.out.println("Goodbye");
        }
    }
}

package Concepts.Medium.UserCreatedExceptions;

public class UserCreatedExceptions {

    public static void main(String[] args) {
        // source:
        // - https://www.baeldung.com/java-new-custom-exception custom exception syntax

        // Supposed we wanted to throw an exception that Java doesn't have...
        // e.g. - capture business rule violations
        // e.g. - offer more informative exception messages, and handle a more specific
        //  exceptions than the ones Java provides
        demonstrateCustomUncheckedException();
        demonstrateCustomCheckedException();
    }

    private static void demonstrateCustomUncheckedException() {
        try {
            throw new CustomUncheckedException("I'm a custom unchecked exception!");
        } catch (CustomUncheckedException err) {
            System.out.println("I'm a custom unchecked exception!");
        }
    }

    private static void demonstrateCustomCheckedException() {
        try {
            throw new CustomCheckedException("I'm a custom checked exception!");
        } catch (CustomCheckedException err) {
            System.out.println("I'm a custom checked exception!");
        }
    }
}

package Concepts.Medium.UserCreatedExceptions;

class CustomCheckedException extends Exception {

    CustomCheckedException(String errorMessage) {
        super(errorMessage);
    }
}

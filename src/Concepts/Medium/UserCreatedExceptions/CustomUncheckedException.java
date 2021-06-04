package Concepts.Medium.UserCreatedExceptions;

class CustomUncheckedException extends RuntimeException {

    CustomUncheckedException(String errorMessage) {
        super(errorMessage);
    }
}

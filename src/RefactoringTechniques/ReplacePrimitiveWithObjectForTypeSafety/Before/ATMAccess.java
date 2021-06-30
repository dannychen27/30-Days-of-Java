package RefactoringTechniques.ReplacePrimitiveWithObjectForTypeSafety.Before;

class ATMAccess {

    private String state;

    // state is not encapuslated.
    // no getters and setters present...

    // move state to new class
    // or create a new enum for the card states.
    private final static String CARD_ENTERED = "CARD ENTERED";
    private final static String VALID_CARD = "VALID CARD";
    private final static String VALID_PIN = "VALID PIN";
    private final static String VALID_CASH_REQUEST = "VALID CASH REQUEST";
    private final static String DENIED = "DENIED";

    private final static int CARD_NUMBER = 123456789;
    private final static int PIN_NUMBER = 1234;
    private final static double CARD_BALANCE = 1000.00;

    private ATMAccess() {
        state = CARD_ENTERED;
    }

    private void verifyCard(int cardNumber) {
        if (CARD_NUMBER == cardNumber) {
            state = VALID_CARD;
        } else {
            state = DENIED;
        }
    }

    private void verifyPIN(int pinNumber) {
        if (PIN_NUMBER == pinNumber) {
            state = VALID_PIN;
        } else {
            state = DENIED;
        }
    }

    private void verifyWithdrawalAmount(double withdrawalRequest) {
        if (withdrawalRequest <= CARD_BALANCE) {
            state = VALID_CASH_REQUEST;
        } else {
            state = DENIED;
        }
    }

    public static void main(String[] args) {
        ATMAccess user = new ATMAccess();
        System.out.println(user.state);
        user.verifyCard(123456789);
        System.out.println(user.state);
        user.verifyPIN(1234);
        System.out.println(user.state);
        user.verifyWithdrawalAmount(99);
        System.out.println(user.state);
    }
}

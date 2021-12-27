package RefactoringTechniques.ReplacePrimitiveWithObjectForTypeSafety.After;

public class ATMCardState {

    // These type safe constants live in the class and can't be impersonated
    final static ATMCardState CARD_ENTERED = new ATMCardState("CARD ENTERED");
    final static ATMCardState VALID_CARD = new ATMCardState("VALID CARD");
    final static ATMCardState VALID_PIN = new ATMCardState("VALID PIN");
    final static ATMCardState VALID_CASH_REQUEST = new ATMCardState("VALID CASH REQUEST");
    final static ATMCardState DENIED = new ATMCardState("DENIED");

    final static int CARD_NUMBER = 123456789;
    final static int PIN_NUMBER = 1234;
    final static double CARD_BALANCE = 1000.00;

    private final String name;

    private ATMCardState(String name) {
        this.name = name;
    }

    public String toString() {
        return name;
    }
}

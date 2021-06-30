package RefactoringTechniques.ReplacePrimitiveWithObjectForTypeSafety.After;

class ATMAccess {

    // define some type safe fields
    private ATMCardState cardState;

    private ATMAccess() {
        setState(ATMCardState.CARD_ENTERED);
    }

    private ATMCardState getState() {
        return cardState;
    }

    // define some type safe assignment
    private void setState(ATMCardState newState) {
        cardState = newState;
    }

    private void verifyCard(int cardNumber) {
        if (!getState().equals(ATMCardState.CARD_ENTERED)) {
            setState(ATMCardState.DENIED);
            return;
        }

        if (cardNumber == ATMCardState.CARD_NUMBER) {
            setState(ATMCardState.VALID_CARD);
        }  else {
            setState(ATMCardState.DENIED);
        }
    }

    private void verifyPIN(int pinNumber) {
        if (!getState().equals(ATMCardState.VALID_CARD)) {
            setState(ATMCardState.DENIED);
            return;
        }

        if (pinNumber == ATMCardState.PIN_NUMBER) {
            setState(ATMCardState.VALID_PIN);
        } else {
            setState(ATMCardState.DENIED);
        }
    }

    private void verifyWithdrawalAmount(double withdrawalRequest) {
        if (withdrawalRequest > ATMCardState.CARD_BALANCE) {
            setState(ATMCardState.DENIED);
            return;
        }

        if (getState().equals(ATMCardState.VALID_PIN)) {
            setState(ATMCardState.VALID_CASH_REQUEST);
        } else {
            setState(ATMCardState.DENIED);
        }
    }

    public static void main(String[] args) {
        ATMAccess user = new ATMAccess();
        System.out.println(user.getState());
        user.verifyCard(123456789);
        System.out.println(user.getState());
        user.verifyPIN(1234);
        System.out.println(user.getState());
        user.verifyWithdrawalAmount(1000.00);
        System.out.println(user.getState());
    }
}
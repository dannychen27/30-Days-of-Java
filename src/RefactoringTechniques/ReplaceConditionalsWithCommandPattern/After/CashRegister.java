package RefactoringTechniques.ReplaceConditionalsWithCommandPattern.After;

class CashRegister {
    Command command;

    public CashRegister(Command command) {
        this.command = command;
    }

    public void returnFinalBill(double amountDue) {
        command.executeCalculationBill(amountDue);
    }
}

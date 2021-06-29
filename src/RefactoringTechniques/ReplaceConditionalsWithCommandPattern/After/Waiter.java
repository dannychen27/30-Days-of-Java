package RefactoringTechniques.ReplaceConditionalsWithCommandPattern.After;

class Waiter implements Command {

    BillPayer customer;  // a customer

    Waiter(BillPayer customer) {
        this.customer = customer;
    }

    public void executeCalculationBill(double amountDue) {
        customer.calculateBill(amountDue);
    }
}

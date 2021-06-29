package RefactoringTechniques.ReplaceConditionalsWithCommandPattern.After;

class UseCashRegister {

    public static void main(String[] args) {
        BillPayer shawnMendes = CustomerTypePicker.getManUnder60();
        Waiter charliePuth = new Waiter(shawnMendes);
        CashRegister calculateBill = new CashRegister(charliePuth);
        calculateBill.returnFinalBill(12.00);

        BillPayer paulThumb = CustomerTypePicker.getManOver60();
        Waiter charliePuth2 = new Waiter(paulThumb);
        calculateBill = new CashRegister(charliePuth2);
        calculateBill.returnFinalBill(12.00);

        CustomerGroup customerGroup = new CustomerGroup();
        customerGroup.add(CustomerTypePicker.getManUnder60());
        customerGroup.get(0).calculateBill(12);
    }
}

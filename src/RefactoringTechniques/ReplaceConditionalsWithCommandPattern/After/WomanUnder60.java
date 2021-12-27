package RefactoringTechniques.ReplaceConditionalsWithCommandPattern.After;

class WomanUnder60 implements BillPayer {

    public void calculateBill(double amountDue) {
        System.out.println("Bill Amount for Women Under 60: $" + (amountDue - amountDue * 0.05));
    }
}

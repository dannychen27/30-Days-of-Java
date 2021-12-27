package RefactoringTechniques.ReplaceConditionalsWithCommandPattern.After;

class ManOver60 implements BillPayer {

    public void calculateBill(double amountDue) {
        System.out.println("Bill Amount for Man Over 60: $" + (amountDue - amountDue * 0.05));
    }
}

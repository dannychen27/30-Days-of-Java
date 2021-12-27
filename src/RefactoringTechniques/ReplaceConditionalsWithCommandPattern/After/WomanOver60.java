package RefactoringTechniques.ReplaceConditionalsWithCommandPattern.After;

class WomanOver60 implements BillPayer {

    public void calculateBill(double amountDue) {
        System.out.println("Bill Amount for Women Over 60: $" + (amountDue - amountDue * 0.10));
    }
}
